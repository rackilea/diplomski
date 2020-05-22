import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

class DistributionUI {

    public static void main(String[] args) {
        System.out.println("Enter a complete file path to file you would like to open:");

        final JFileChooser fchooser = new JFileChooser() {

            private static final long serialVersionUID = 1L;

            public void approveSelection() {
                File inFile = getSelectedFile();

                if (inFile.exists() ) {
                    FileReader ins = null;

                    try {
                        ins = new FileReader(inFile);
                        int ch;
                        while ((ch = ins.read()) != -1) {
                            System.out.print((char) ch);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            ins.close();
                        } catch (Exception e) {
                        }
                    }
                }
                super.approveSelection();
            }
        };
        fchooser.setCurrentDirectory(new File("."));
        fchooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("my file", "txt");
        fchooser.addChoosableFileFilter(filter);
        fchooser.showOpenDialog(null);


    } // main end
}