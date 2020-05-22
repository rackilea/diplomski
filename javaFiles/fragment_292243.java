Process process = new ProcessBuilder(command).redirectErrorStream(true)
    .start();
InputStream in = process.getInputStream();
try {
  Scanner scanner = new Scanner(in);
  while (scanner.hasNextLine()) {
    lines.add(scanner.nextLine());
  }
  if (process.exitValue() != 0 || scanner.ioException() != null) {
    // throw exceptions
  }
} finally {
  in.close();
}