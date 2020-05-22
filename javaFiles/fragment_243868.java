int sum = 0;
final String[] mins = new String[] { "00:05", "00:30", "00:25" };
for (String str : mins) {
    String[] parts = str.split(":");
    sum += Integer.parseInt(parts[1]);
}
System.out.println(sum);