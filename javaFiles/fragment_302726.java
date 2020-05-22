try (BufferedReader br = new BufferedReader(new FileReader(args[0]));
     BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")))) {
  // I/O code...
} catch (IOException ex) {
  ex.printStackTrace();
}