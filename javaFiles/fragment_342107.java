private void loadScores()
{
  File file = new File(saveDataPath, filename);

  try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
    String line = reader.readLine();

    // line = reader.readLine() <-- REMOVE THIS LINE
    wins = Integer.parseInt(line);

    line = reader.readLine();
    losses = Integer.parseInt(line);

    reader.close();


  }
  catch (Exception e) {
    e.printStackTrace();
  }
}