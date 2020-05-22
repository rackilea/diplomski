String path = "C:/Users/Luis/Desktop/RESEARCHGUIPROJECT/ResearchGUI/CHEMKED/";
  String app = "CHEMKED_SOLVER.exe";
  List<String> command = new ArrayList<String>();
  // command.add(path);
  command.add(app);
  ProcessBuilder processBuilder = new ProcessBuilder(command);
  processBuilder.directory(new File(path));
  processBuilder.redirectError();
  Process process = processBuilder.start();

  BufferedReader bReader = new BufferedReader(
      new InputStreamReader(process.getInputStream()));
  String line = "";
  while ((line = bReader.readLine()) != null) {
     System.out.println(line);
  }