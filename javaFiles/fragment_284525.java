String wholetext = "Place Then Pin- **110065 Name and address** Alias 1 ID of customer-123 Some Place ";
    String textafter = "110065 Name and address";
    String textbefore = "ID of customer";

    int index1 = wholetext.indexOf(textbefore);
    int index2 = wholetext.indexOf(textafter) + textafter.length();

    String namerequired = wholetext.substring(index2, index1);
    System.out.println(namerequired);