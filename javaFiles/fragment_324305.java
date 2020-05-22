String splitBy = ";"; // As I am using CSV file below I used ";" as splitter. You can change as per your needs

  BufferedReader br = new BufferedReader(new FileReader("file.csv"));
  String line = br.readLine();
  while((line = br.readLine()) != null)
  {
       String[] b = line.split(splitBy);
       //Take actions you need to perform
  }
  br.close();