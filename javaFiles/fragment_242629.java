String command = "/Applications/MiKTeX Console.app/Contents/bin/miktex-pdftex";
String outputDir = System.getProperty("user.dir");
String sourceFile = "Sample.tex";

List<String> commands = new ArrayList<>();
commands.add(command);
commands.add("--interaction=nonstopmode");
commands.add("--output-directory=" + outputDir);
commands.add(sourceFile);