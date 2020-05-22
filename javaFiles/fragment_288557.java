public void actionPerformed(ActionEvent arg0) {

    String sLine;

    Vector<Score> scoreVec = new Vector<Score>();

    //Here I am getting a FileNotFoundException for (new FileReader("scores.txt")
    try (BufferedReader in = new BufferedReader(new FileReader("scores.txt"))) {

        //Here I am getting an IOException for in.readLine()
        while ((sLine = in.readLine()) != null) {
            scoreVec.addElement(new Score(sLine));
        }

    } catch (IOException exp) {
        exp.printStackTrace();
    }

    //Placeholders until I get the rest of the program working
    System.out.println(scoreVec.get(1).name);
    System.out.println(scoreVec.get(1).country);
}