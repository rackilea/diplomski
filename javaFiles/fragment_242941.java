import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class OpenHWPFFromURL {

 public static void main(String[] args) throws Exception {

  String stringURL = "http://prevention.cancer.gov/sites/default/files/uploads/clinical_trial/Master-DMP-Template.doc";

  URL url = new URL(stringURL);
  HttpURLConnection con = (HttpURLConnection)url.openConnection();

  int responseCode = con.getResponseCode();
  System.out.println(responseCode); //301 Moved Permanently

  if (responseCode != HttpURLConnection.HTTP_OK) {
   if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP
       || responseCode == HttpURLConnection.HTTP_MOVED_PERM
       || responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
    url = new URL(con.getHeaderField("Location")); //get new location
    con = (HttpURLConnection)url.openConnection();
   }   
  }

  InputStream in = con.getInputStream();
  HWPFDocument doc = new HWPFDocument(in);
  WordExtractor extractor = new WordExtractor(doc);
  String text = extractor.getText();

  System.out.println(text);

 }
}