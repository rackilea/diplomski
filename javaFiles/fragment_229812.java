Pattern r = Pattern.compile("(.*?)/(\\d+)/(\\2)_(\\d+)\\.jpg");
Matcher m = r.matcher(file_path);
if (m.matches()) {
    System.out.println("Match found");
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
    System.out.println(m.group(4));
}