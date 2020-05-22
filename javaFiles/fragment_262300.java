Pattern regex = Pattern.compile(".*<Anhang>(.+?)</Anhang>.*", Pattern.DOTALL);

String s = "BLALBLA BLA BLA <Anhang> \n" +
           "gonegone gone gone ,os .psd\n" +
           "</Anhang> ajdajadw";

Matcher m = regex.matcher(s);

if (m.matches()) {
    String capturedGroup = m.group(); // This is the text inside the tags
}