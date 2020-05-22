BufferedReader br = new BufferedReader(new FileReader(file));
String line = null;
ArrayList<String> allLines = new ArrayList<String>();

while((line = br.readLine()) != null) {
     allLines.add(line);
     if (allLines.size() > 500) {
          processLines(allLines);
          allLines.clear();
     }
}

processLines(allLines);