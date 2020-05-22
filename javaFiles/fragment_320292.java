Scanner s = new Scanner(new File("Grades.txt"));
int i = 0;
while (s.hasNextLine()) {
    id[i] = s.nextInt();
    System.out.println(id[i]);
    // (The remaining fields could be read with s.next())
    s.nextLine(); // skip rest of line
    i++;
}