public static void main(String[] args) throws IOException {
    InputStream file = new FileInputStream(args[0]);
    try {
      file = new BufferedInputStream(file);
      CharsetDetector detector = new CharsetDetector();
      detector.setText(file);
      String tableTemplate = "%10s %10s %8s%n";
      System.out.format(tableTemplate, "CONFIDENCE",
          "CHARSET", "LANGUAGE");
      for (CharsetMatch match : detector.detectAll()) {
        System.out.format(tableTemplate, match
            .getConfidence(), match.getName(), match
            .getLanguage());
      }
    } finally {
      file.close();
    }
  }