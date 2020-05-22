String csv = "'happiness,sadness','abc's','another's'";
    Pattern pattern = Pattern.compile("('[^\']*?\'|[^,\r\n]*?)([,\r\n]|$)");

    Matcher match = pattern.matcher(csv);
    while (match.find()) {
          System.out.println(match.group(1));
    }