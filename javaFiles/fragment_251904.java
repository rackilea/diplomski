byte[] thisAppCanBreak = "this app can break"
        .getBytes("ISO-8859-1");
    CharsetDetector detector = new CharsetDetector();
    detector.setText(thisAppCanBreak);
    String tableTemplate = "%10s %10s %8s%n";
    System.out.format(tableTemplate, "CONFIDENCE",
        "CHARSET", "LANGUAGE");
    for (CharsetMatch match : detector.detectAll()) {
      System.out.format(tableTemplate, match
          .getConfidence(), match.getName(), match
          .getLanguage());
    }