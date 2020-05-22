Scanner sc = new Scanner(new File(file));
int index = 0;
while(sc.hasNextLine()) {
    String line = sc.nextLine();
    String[] tokens = line.split(" ");
    names[index] = tokens[0];
    counts[index] = Integer.parseInt(tokens[1]);
    index++;
}