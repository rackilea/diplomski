String[] letter = new String[26];
String[] symbol = new String[26];
int count = 0;
while (sc.hasNextLine()) {
    String line = sc.nextLine();
    String[] lst = line.split(" ");
    letter[count] = lst[0];
    symbol[count] = lst[1];
    count++;
}
for (int i = 0; i < count; i++)
    System.out.println(letter[i] + " " + symbol[i]);