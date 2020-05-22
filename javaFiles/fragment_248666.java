import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {

        try {
            // connect and download the file
            URL website = new URL("http://www.anaptyxi.gov.gr/DesktopModules" +
                    "/AVMap.ErgaReports_v2/SearchHandler.ashx?lang=el-GR" +
                    "&pageMode=3&searchValue=&searchField=&dateFrom=&dateTo=" +
                    "&perioxesMode=2&selectedPerioxes[]=01_36_514&ergaType[]=1" +
                    "&ergaType[]=2&ergaType[]=3&enisx=&kad=&company=&includePollaplhs=1" +
                    "&export=xls");
            URLConnection con = website.openConnection();
            con.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");

            Files.copy(con.getInputStream(), FileSystems.getDefault().getPath("test.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}