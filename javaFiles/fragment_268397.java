try (
  FileInputStream in = new FileInputStream("input.jar");
  FileOutputStream out = new FileOutputStream("output.jar");
) {
  instrumenter.instrumentAll(in, out, "input.jar");
}