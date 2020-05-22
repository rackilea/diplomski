while (br.ready()) {
   if (br.readLine().contains("CREATE PROCEDURE")) {
      while (!br.readLine().contains("END PROCEDURE;")) {
         i++;
      }
    }
    new PrintStream(fout).println(i);
    i = 0;
}