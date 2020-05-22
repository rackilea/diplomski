File file = new File("points.txt");

// checking if file is empty, so it enters imaginary players and scores
// if it is.'
if ((!file.exists()) || (file.length() == 0)) {
    try (BufferedWriter writ = new BufferedWriter(new FileWriter(file))) {
        for (int i = 1; i < 6; i++) {
            writ.write("Player" + i + "\t\t" + "99:99");
            writ.newLine();
        }
    }
    // writ is closed by the try()
}
try (BufferedReader rea = new BufferedReader(new FileReader(file))) {
    ArrayList<String> top = new ArrayList<String>();

    String readthis;
    while ((readthis = rea.readLine()) != null) {
        top.add(readthis);
    }
}
// rea is safely closed by the try()