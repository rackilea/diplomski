private String readNonEmptyLine(BufferedReader reader) {
     while(reader.ready()) {
          String nextLine = reader.readLine();
          if(!nextLine.isEmpty()) return nextLine;
     }
     return "";
}