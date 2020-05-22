String line = "%22key1%22:%5Bvalue1%5D, %22key2%22:%5Bvalue2%5D,";

Matcher m = Pattern.compile("%22(.*?)%22:%5B(.*?)%5D").matcher(line);
while (m.find()) {
    for (int i = 1; i <= m.groupCount(); i++) {
        System.out.print(m.group(i) + " ");
    }
    System.out.println();
}