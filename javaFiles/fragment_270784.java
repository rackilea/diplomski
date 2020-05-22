// for reading
FileReader fin = new FileReader("highscores.txt");
Scanner sc = new Scanner(fin);

highScore = din.nextInt();
highScore.setText("High Score: " + highScore);
sc.close();

// for writing
FileWriter fos = new FileWriter("highscores.txt");
PrintWriter pw = new PrintWriter(fos);
pw.println(highScore);
pw.close();