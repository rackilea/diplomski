String dateFormatNormal = strLine;
/* Debug: is there an unexpected unicode codepoint hiding in there? */
    System.out.println("Received: " + dateFormatNormal.codePoints()
            .mapToObj(i -> String.format("0x%04x (%s)", i, String.valueOf(Character.toChars(i))))
            .collect(Collectors.toList()));
    System.out.println("Expected: " + "21/01/2017".codePoints()
            .mapToObj(i -> String.format("0x%04x (%s)", i, String.valueOf(Character.toChars(i))))
            .collect(Collectors.toList()));
/* Remove Debug code when done */