package de.scrum_master.app;

import de.schlichtherle.truezip.file.TFile;
import de.schlichtherle.truezip.nio.file.TPath;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class TPathHelper {
  private final TPath originalPath;
  private TPath caseSensitivePath;

  public TPathHelper(TPath tPath) {
    originalPath = tPath;
  }

  public TPath getOriginalPath() {
    return originalPath;
  }

  public TPath getCaseSensitivePath() throws IOException, URISyntaxException {
    if (caseSensitivePath != null)
      return caseSensitivePath;
    final TPath absolutePath = new TPath(originalPath.toFile().getCanonicalPath());
    TPath matchingPath = absolutePath.getRoot();
    for (Path subPath : absolutePath) {
      boolean matchFound = false;
      for (TFile candidateFile : matchingPath.toFile().listFiles()) {
        if (candidateFile.getName().equalsIgnoreCase(subPath.toString())) {
          matchFound = true;
          matchingPath = new TPath(matchingPath.toString(), candidateFile.getName());
          break;
        }
      }
      if (!matchFound)
        throw new IOException("element '" + subPath + "' not found in '" + matchingPath + "'");
    }
    caseSensitivePath = matchingPath;
    return caseSensitivePath;
  }
}