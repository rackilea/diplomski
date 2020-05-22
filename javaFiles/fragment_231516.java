package de.scrum_master.stackoverflow;

import org.apache.commons.validator.routines.UrlValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class DownloadFile {
  private UrlValidator urlValidator = UrlValidator.getInstance();

  void setUrlValidator(UrlValidator urlValidator) {
    this.urlValidator = urlValidator;
  }

  public BufferedReader downloadGzipCsvFile(String url) throws MalformedURLException {
    BufferedReader br = null;
    if (urlValidator.isValid(url)) {
      try {
        br = new BufferedReader(
          new InputStreamReader(
            new GZIPInputStream(
              new URL(url).openStream()
            )
          )
        );
      } catch (IOException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }
    else {
      throw new MalformedURLException("Supplied URL: " + url + " is an invalid URL");
    }
    return br;
  }
}