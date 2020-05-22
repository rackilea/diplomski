String line;
BufferedReader br = new BufferedReader(new FileReader(file));
while ((line = br.readLine()) != null) {
   // do some cool stuff with this line.
}
br.close();