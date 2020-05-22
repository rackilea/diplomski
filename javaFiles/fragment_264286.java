JButton btnImportExcelFiles = new JButton("EXCEL FILES");

btnImportExcelFiles.setIcon(new ImageIcon(racunariAplikacija.class.getResource("/image/Excel-icon.png")));

btnImportExcelFiles.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent arg0)
    {
        FileFilter filter = new FileNameExtensionFilter("Excel Files", "xls");

        // here is my file chooser
        JFileChooser jf = new JFileChooser();
        jf.addChoosableFileFilter(filter);
        int rezultat = jf.showOpenDialog(null);

        if(rezultat == JFileChooser.APPROVE_OPTION)
        {
            String excelPath = jf.getSelectedFile().getAbsolutePath();
            ArrayList<Stavka>lista  = new ArrayList<>();
            File f = new File(excelPath);
            Workbook wb = null;
            try
            {
                wb = Workbook.getWorkbook(f);
            }
            catch (BiffException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            // this is where i call for nested forloop
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();
            System.out.println("redovi" + row + "kolone" + col);

            for (int i = 0; i < 18; i++)
            {
                Stavka stavka = new Stavka(); // new instance <<<<<<<<

                for (int j = 0; j < col; j++)
                {
                    Cell c = s.getCell(j,i);
                    if(j==0) {stavka.setStavkaID(Integer.parseInt(c.getContents().toString()));}
                    else if(j==1) {}
                    else if(j==2) {stavka.setSifraKomponente(c.getContents().toString());}
                    else if(j==3) {stavka.setOpis(c.getContents().toString());}
                    else if(j==4) {stavka.setVrednost(c.getContents().toString());}
                    else if(j==5) {stavka.setKuciste(c.getContents().toString());}
                    else if(j==6) {stavka.setSektor(c.getContents().toString());}
                    else if(j==7) {stavka.setRack(c.getContents().toString());}
                    else if(j==8) {stavka.setProizvodjac(c.getContents().toString());}
                    else if(j==9) {stavka.setKolicina(Integer.parseInt(c.getContents().toString()));}

                }   
                lista.add(stavka); // inside second for loop <<<<<<<<
            }

            // outside the second for loop <<<<<<<<<<<<<<<<<<<<<<<<<<
            // this is my tableModel
            TabelaStavka stavka1 = new TabelaStavka(lista);
            tblAzuriranjeMagacina.setModel(stavka1);
        }
    }
}