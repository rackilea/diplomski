package ouvrirDossier;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ouvrirDossier{

    private static String path;

    private static final JOptionPane optionPane = new JOptionPane(
            "The only way to close this dialog is by\n"
                    + "pressing one of the following buttons.\n"
                    + "Do you understand?",
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_NO_OPTION);

    public static void main(String[] args){
        // ON CREE LE CHEMIN D'ACCES AU DOSSIER EN COLLANT TOUT LES BOUS.
        path = "A:\\";
        if(args.length>0){
            int cpt;
            for(cpt = 1;cpt<args.length;cpt++){
                if( cpt == 0)
                    path += args[cpt].replaceAll(";"," ");
                else{
                    if(cpt==1)
                        path += args[cpt].replaceAll(";"," ");
                    else
                        path += "\\"+args[cpt].replaceAll(";"," ");
                }
            }
        }

        //ouvrirAlerte(path);
        // ON REGARDE SI LE DOSSIER EXISTE
        if(ouvrirDossier(path) == false){
            String chemin = "";
            String cheminTemp = "";
            boolean okMatch = false;
            boolean trouve = false;
            String[] etages = path.split("\\\\");
            outerloop:
            for(int a=1; a<etages.length; a++){
                if(trouve == false){
                    chemin = "";
                    cheminTemp = "";
                    for(int b=0; b<a; b++){
                        chemin += etages[b]+"\\";
                    }
                    //System.out.println(chemin);
                    File theDir = new File(chemin);
                    if(!theDir.exists()){
                        for(int b=0; b<a-1; b++){
                            cheminTemp += etages[b]+"\\";
                        }
                        File theDirTemp = new File(cheminTemp);
                        //System.out.println(chemin);
                        //System.out.println(cheminTemp);
                        ArrayList<String> noms = new ArrayList<String>(Arrays.asList(theDirTemp.list()));
                        okMatch = false;
                        for(int c=0; c<noms.size(); c++){
                            String regexPattern = Pattern.quote(etages[a-1])
                                     .replace("é", "[eéèêë]")
                                     .replace("u", "[ùúûü]")
                                     .replace("oe", "(oe|œ)")
                                     .replace("a", "[aàâä]");
                            Pattern pattern = Pattern.compile(regexPattern);
                            Matcher matcher = pattern.matcher(noms.get(c));
                            while(matcher.find()){
                                okMatch = true;
                                etages[a-1] = noms.get(c+1);
                                /*
                                String test = "";
                                for(int e=0; e<etages.length; e++){
                                    test += etages[e]+"\\";
                                }
                                */
                                a--;
                                //System.out.println(test);
                            }
                        }
                        if(!okMatch)
                            break outerloop;
                    }
                    if(a == etages.length-1 && theDir.exists())
                        trouve = true;
                }
            }

            if(trouve){
                ouvrirDossier(chemin);
            }
            else{
                int selectedOption = JOptionPane.showConfirmDialog(null, 
                    "Le dossier que vous tentez d'ouvrir ("+path+")ne semble pas exister, voulez vous le créer ?", 
                    "SPB - Le dossier n'existe pas", 
                    JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION){
                    if(args[0].equals("T")){
                        new File(path).mkdirs();
                        new File(path+"/Support/Doc").mkdirs();
                        new File(path+"/Support/Dev").mkdirs();
                        // ------------->
                        new File(path).mkdirs();
                        new File(path+"/Courriel").mkdirs();
                            new File(path+"/Courriel/Entrant").mkdirs();
                            new File(path+"/Courriel/Sortant").mkdirs();
                        new File(path+"/Document de Base").mkdirs();
                        new File(path+"/Document Intermediaire").mkdirs();
                        new File(path+"/Donnee").mkdirs();
                            new File(path+"/Donnee/Dsr").mkdirs();
                            new File(path+"/Donnee/Dsi").mkdirs();
                        new File(path+"/Livrable").mkdirs();
                        new File(path+"/Programme").mkdirs();
                    }
                    else if(args[0].equals("P")){
                        new File(path).mkdirs();
                        new File(path+"/Support/Doc").mkdirs();
                        new File(path+"/Support/Dev").mkdirs();
                    }
                    ouvrirDossier(path);
                }
            }
        }
    }

    private static boolean ouvrirDossier(String chemin){
        File theDir = new File(chemin);
        //System.out.println(chemin);
        if(theDir.exists()){
            // SI OUI ON L'OUVRE
            try{
                Runtime runTime = Runtime.getRuntime();
                Process process = runTime.exec("explorer "+chemin);
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public static void ouvrirAlerte(String texte){
        JFrame frame = new JFrame("SPB");
        frame.setPreferredSize(new Dimension(1270, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel(texte);
        frame.add(label1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public int nbLettre(char lettre, String mot){
        int resultat = 0;
        for(int a=0; a<mot.length(); a++){
            if(mot.substring(a, a+1).equals(lettre)){
                resultat++;
            }
        }
        return resultat;
    }
}