public class HexaController implements Initializable {

    private org.jdom2.Document document;

    private JFrame fileDialog;
    private Element racine;
    private String Nom_dar;
    private java.util.List<Element> listeDAS;
    private ArrayList<String> Nom_das = new ArrayList();
    private ArrayList<String> Nom_task = new ArrayList();
    private ArrayList<String> Nom_Variable1 = new ArrayList();
    private ArrayList<String> Resultat_Variable1 = new ArrayList();
    private ArrayList<Double> Resultat_Variabledouble1 = new ArrayList<Double>();
    private ArrayList<String> ResultatHexa_Variable1 = new ArrayList<String>();
    private ArrayList<String> Lien = new ArrayList();
    private java.util.List<Element> ListeTRIAL;
    private java.util.List<Element> listeTASK;
    private java.util.List<Element> listeOperation;
    private List listeOperation_delta;
    private java.util.List<Element> listeArgument;
    private List listeArgument_delta;

    @FXML
    private ComboBox<String> hexa;
    ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    private TextField entree;

    @FXML
    private TextField nomfichier;

    @FXML
    private TextField excel;

    @FXML
    private TextField sortie;

    @FXML
    private void dar(ActionEvent event) {
        FileDialog fd1 = new FileDialog(fileDialog, "Choisissez un fichier .dar", FileDialog.LOAD);
        fd1.setDirectory("C:\\");
        fd1.setVisible(true);
        String filename1 = fd1.getFile();
        String Directory1 = fd1.getDirectory();
        String path1 = Directory1 + filename1;
        entree.setText(path1);
        nomfichier.setText(filename1);
    }

    @FXML
    private void modele(ActionEvent event) {
        JFrame parentFrame = new JFrame();
        FileDialog filechooser = new FileDialog(parentFrame, "Choisir un modèle Excel à copier", FileDialog.LOAD);
        filechooser.setDirectory("C:\\");
        filechooser.setVisible(true);
        String directory_copy = filechooser.getDirectory();
        String name_copy = filechooser.getFile();
        String path_copy = (directory_copy + name_copy);
        excel.setText(path_copy);
    }

    @FXML
    private void sortie(ActionEvent event) {
        JFrame parentFrame2 = new JFrame();
        FileDialog filechooser2 = new FileDialog(parentFrame2, "Choisir une destination d'enregistrement", FileDialog.SAVE);
        filechooser2.setDirectory("C:\\");
        filechooser2.setVisible(true);
        String directory_save = filechooser2.getDirectory();
        String name_save = filechooser2.getFile();
        String path_save = (directory_save + name_save + ".xls");
        sortie.setText(path_save);
    }

    @FXML
    private void annuler(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private ComboBox<Integer> methode;
    ObservableList<Integer> nombre = FXCollections.observableArrayList();

    @FXML
    private void exe(ActionEvent event) throws Throwable {
        SAXBuilder sxb = new SAXBuilder();
        String filename1 = nomfichier.getText();
        if (filename1 == null) {
            System.out.println("Annulation");
            System.exit(0);
        } else {
            try {
                //On crée un nouveau document JDOM avec en argument le fichier XML
                //Le parsing est terminé 
                String path1 = entree.getText();
                document = sxb.build(new File(path1));
                //On initialise un nouvel élément racine avec l'élément racine du document.
                racine = document.getRootElement();
                System.out.println("Lecture du premier .dar");
            } catch (Exception e) {
                System.out.println("FATAL ERROR !");
                System.exit(0);
            }
        }
        afficheALL();

        Xl();
    }

    //RECUPERATION DES DONNEES DU FICHIER DAR
    private void afficheALL() {
        //Variables Locales
        String Str;
        String Str_bis;
        Nom_dar = racine.getAttributeValue("label");

        System.out.println("Nom du fichier dar : " + Nom_dar + "\n");

        listeDAS = racine.getChildren("DAS");
        //On crée un Iterator sur notre liste
        Iterator<Element> i1 = listeDAS.iterator();

        ////TRAITEMENT POUR CHAQUE DAS
        String m[] = new String[50];
        m[0] = "Marqueur de Sortie";
        m[1] = "Nb Occurences";
        m[2] = "Valeur Physique";
        m[3] = "Résultat";
        m[4] = "Valeur de Sortie";

        int s = methode.getValue();
        int n;
        for (n = 5; n < 5 + s; n++) {

            //System.out.println("Entrez le nom de la methode");
            //Scanner methode = new Scanner(System.in);
            //String name=methode.nextLine();
            //m[n]=name;
        }
        int j;
        for (j = 0; j < 5 + s; j++) {
            System.out.println("Le nom de la methode " + j + " est :" + m[j]);
        }
        while (i1.hasNext()) {
            Element courant = (Element) i1.next();
            //On affiche le nom de l’élément courant
            Str = courant.getAttributeValue("dasFullFileName").toString();
            System.out.println("Nom du DAS: " + Str);
            Nom_das.add(Str);

            ListeTRIAL = courant.getChildren("TRIAL");
            @SuppressWarnings("rawtypes")
            Iterator T1 = ListeTRIAL.iterator();

            while (T1.hasNext()) {
                Element courant2 = (Element) T1.next();
                Lien.add(courant2.getAttributeValue("xconvFullFileName").toString());
            }

            listeTASK = courant.getChildren("TASK");
            @SuppressWarnings("rawtypes")
            Iterator k1 = listeTASK.iterator();

            while (k1.hasNext()) {
                Element courant2 = (Element) k1.next();
                Str_bis = courant2.getAttributeValue("label").toString();
                System.out.println(Str_bis);

                listeOperation = courant2.getChildren("Operation");
                @SuppressWarnings("rawtypes")
                Iterator l1 = listeOperation.iterator();

                while (l1.hasNext()) {
                    Element courant3 = (Element) l1.next();
                    listeArgument = courant3.getChildren("Argument");
                    @SuppressWarnings("rawtypes")
                    Iterator m1 = listeArgument.iterator();

                    while (m1.hasNext()) {

                        Element courant4 = (Element) m1.next();
                        int l;

                        for (l = 0; l < 5 + s; l++) {
                            if (courant4.getAttributeValue("parameterName").compareTo(m[l]) == 0) {
                                Nom_Variable1.add(courant4.getAttributeValue("argumentName"));
                                double d = Double.parseDouble(courant4.getAttributeValue("instantValue"));
                                DecimalFormat df = new DecimalFormat(".#");
                                df.setMaximumFractionDigits(20);
                                String sortie = df.format(d);
                                long entier = (long) d;
                                String hex = Long.toHexString(entier).toUpperCase();
                                //hex.toUpperCase();
                                Resultat_Variable1.add(sortie);
                                Resultat_Variabledouble1.add(d);
                                ResultatHexa_Variable1.add(hex);

                            }
                        }
                    }
                }
            }
            System.out.println("Fin lecture XML File");
        }
    }

    private void Xl() throws Throwable {

        try {

            System.out.println("Saisi utilisateur ok");

            //CREATION DES FEUILLES NECESSAIRES A LA RECUPERATION DES DONNEES
            String path_copy = excel.getText();
            String path_save = sortie.getText();
            Workbook copie = Workbook.getWorkbook(new File(path_copy));
            WritableWorkbook sortie = Workbook.createWorkbook(new File(path_save), copie);
            WritableFont bord = new WritableFont(WritableFont.ARIAL, 11);
            WritableCellFormat border = new WritableCellFormat(bord);

            //REMPLISSAGE DE LA PREMIERE FEUILLE AVEC LES DONNEES MESUREES
            System.out.println("---" + Nom_Variable1.size() + "---");
            for (int x = 0; x <= Nom_Variable1.size() - 1; x++) {
                Label Col0 = new Label(0, x, Nom_Variable1.get(x), border);
                sortie.getSheet(1).addCell(Col0);
            }

            for (int y = 0; y <= Resultat_Variabledouble1.size() - 1; y++) {
                Number Col1 = new Number(1, y, Resultat_Variabledouble1.get(y), border);
                sortie.getSheet(1).addCell((WritableCell) Col1);
            }

            for (int y = 0; y <= ResultatHexa_Variable1.size() - 1; y++) {
                Label Col2 = new Label(2, y, ResultatHexa_Variable1.get(y), border);
                sortie.getSheet(1).addCell(Col2);
            }

            System.out.println("Fin Copie Excel");
            sortie.write();
            sortie.close();

        } catch (RowsExceededException e1) {
        } catch (BiffException ex) {
        } catch (WriteException e1) {
        } catch (IOException e) {
        } finally {
            System.out.println("Le fichier à été généré correctement.");
            System.out.println("Appuyez sur 'Entrée' pour terminer le programme");
            System.exit(0);
        }

        System.exit(0);
    }

    public HexaController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        list.add(new String("OUI"));
        list.add(new String("NON"));
        hexa.setItems(list);
        nombre.add(new Integer(0));
        nombre.add(new Integer(1));
        nombre.add(new Integer(2));
        nombre.add(new Integer(3));
        nombre.add(new Integer(4));
        nombre.add(new Integer(5));
        methode.setItems(nombre);
    }

}