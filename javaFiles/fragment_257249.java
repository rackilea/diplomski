FileInputStream fis = new FileInputStream(new File("File.txt"));
BufferedReader br   = new BufferedReader(new InputStreamReader(fis));

String line = null;
while ((line = br.readLine()) != null) {
    String[] parts = line.split(" ");
    String theId = parts[2].substring(0, parts[2].length()-1);
    System.out.println(theId);
}

br.close();