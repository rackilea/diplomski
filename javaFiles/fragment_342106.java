private void writeSaveData(int wins, int losses)
{
  File file = new File(saveDataPath, filename);
  try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
    writer.write(Integer.toString(wins));
    writer.newLine();
    writer.write(Integer.toString(losses));

  }
  catch (Exception e) {
      e.printStackTrace();
  }

}