String fixedSizetoXML(String extractedTestFromPDF) {
    String[] lines = extractedTestFromPDF.split("\\R");
    Pattern pattern = Pattern.compile("^\\s*(\\S.{20})\\s\\s+([-\\d,\\.]+)\\s+.*$");
    //                                      (--------)       (-----------)
    StringBuilder sb = new StringBuilder(lines.length * 64);
    sb.append("<?xml verion="1.0">\n<Xml>\n");
    for (String line : lines) {
        Matcher m = pattern.matcher(line);
        if (m.find()) {
            String data = String.format("<Data>\n"
                            + "    <Allowance>%s</Allowance>\n"
                            + "    <Allowance_Amount>%s</Allowance_Amount>\n"
                            + "</Data>\n",
                            m.group(1).trim(), m.group(2));
            sb.append(data);
        }
    }
    sb.append("<Xml>\n");
    return sb.toString();
}