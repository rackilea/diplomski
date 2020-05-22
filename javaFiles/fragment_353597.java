package de.scrum_master.app;

import de.schlichtherle.truezip.nio.file.TPath;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class Application {
  public static void main(String[] args) throws IOException, URISyntaxException {
    TPathHelper tPathHelper = new TPathHelper(
      new TPath(
        "../../../downloads/powershellarsenal-master.zip/" +
          "PowerShellArsenal-master\\LIB/CAPSTONE\\LIB\\X64\\LIBCAPSTONE.DLL"
      )
    );
    TPath caseSensitivePath = tPathHelper.getCaseSensitivePath();
    System.out.printf("Original path: %s%n", tPathHelper.getOriginalPath());
    System.out.printf("Case-sensitive path: %s%n", caseSensitivePath);
    System.out.printf("File size: %,d bytes%n", Files.readAllBytes(caseSensitivePath).length);
  }
}