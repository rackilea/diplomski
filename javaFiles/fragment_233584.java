String fixedSizetoXML(String extractedTestFromPDF) {
    String[] lines = extractedTestFromPDF.split("\\R");
    Pattern pattern = Pattern.compile("^\\s*(\\S.{20})\\s\\s+([-\\d,\\.]+)\\s+.*$");
    //                                      (--------)       (-----------)
    return "<?xml verion="1.0">\n<Xml>\n"
        + Stream.of(lines)
              .map(pattern::matcher)
              .filter(m::find)
              .map(m -> String.format("<Data>\n"
                            + "    <Allowance>%s</Allowance>\n"
                            + "    <Allowance_Amount>%s</Allowance_Amount>\n"
                            + "</Data>\n",
                            m.group(1).trim(), m.group(2)))

              .collect(Collectors.joining(""))
        + "<Xml>\n";
}