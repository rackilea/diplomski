import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nudanesh
 */
public class URLDownload {

    private Document doc;
    String url = "", folder, file;
    private final File sourceFile;
    int i = 1;
    int r = 1, c = 1;
    int anchorCol = 3;
    Library lib;

    URLDownload() {
        lib = new Library();
        sourceFile = new File("Download.html");
        try {

            doc = Jsoup.parse(sourceFile, "UTF-8");
        } catch (IOException ex) {
            Logger.getLogger(URLDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Elements links = doc.select("a[href]");
        Elements rows = doc.select("tr");
        System.out.println("Size=" + rows.size());
        for (Element row : rows) {


                Elements cols = row.getElementsByTag("td");
                c = 1;
                for (Element col : cols) {
                    System.out.println("Row"+r);
                    if (c == 1) {
                        file = col.text();//System.out.println("File in main"+file);
                    } else if (c == 2) {
                        folder = col.text();//System.out.println("Folder in main"+folder);
                    } else {
                        try {
                            url = col.getElementsByTag("a").attr("href");
                        } catch (Exception e) {
                            System.out.print("-");
                        }
                    }

                    c++;
                }
                if (!url.equals("")) {
                    lib.setLocation(file,folder);
                    lib.downloadFile(url);
                }
                url = "";

            i++;
            r++;
        }
    }

    public static void main(String arg[]) {

        new URLDownload();
    }
}