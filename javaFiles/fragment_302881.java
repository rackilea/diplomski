File file = new File("output.txt");
Scanner input = new Scanner(file);
StringBuilder sb = new StringBuilder();
while (input.hasNextLine()) {
    String[] words = input.nextLine().split(" ");
    for (int i = 0; i < words.length; i++) {
        if (isNumeric(words[i])) {
            break;
        }
        sb.append(words[i] + " ");
    }
    System.out.println(sb);
    sb = new StringBuilder();
}
input.close();