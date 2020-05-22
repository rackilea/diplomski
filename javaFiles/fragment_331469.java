String targetFileStr = IOUtils.toString(new FileInputStream(new File(
        "input.txt")), "UTF-8");
Matcher matcher = Pattern.compile("(?<=(<body>.{0,1000}))<link",
        Pattern.DOTALL).matcher(targetFileStr);
while (matcher.find()) {
    System.out.println(matcher.group(1) + matcher.group());
    System.out.println("---------");
}