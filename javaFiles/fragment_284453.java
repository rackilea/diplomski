String line = "1,21,33";
for (String s : line.split(",")) {
    char[] chars = s.toCharArray();
    int sum = 0;
    for (int i = 0; i < chars.length; i++) {
        sum += (chars[chars.length - i - 1] - '0') * Math.pow(10, i);
    }
    System.out.println(sum);
}