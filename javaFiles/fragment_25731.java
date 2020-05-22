String sampleText = "This    is    a  test of    removing extra spaces";
      StringBuilder sampleTextBuilder = new StringBuilder(sampleText);
      for (int i = sampleTextBuilder.length() - 1; i >= 0; i--) {
         if (sampleTextBuilder.charAt(i) == ' ') {
            // found a space, check front and back of string.
            if (i == sampleTextBuilder.length() - 1 || i == 0) {
               sampleTextBuilder.deleteCharAt(i);
            }
            // otherwise, delete one of them if two are present.
            else if (sampleTextBuilder.charAt(i - 1) == ' ') {
               sampleTextBuilder.deleteCharAt(i - 1);
            }
         }
      }
      sampleText = sampleTextBuilder.toString();
      System.out.println("\"" + sampleText + "\"");