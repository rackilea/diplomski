InputStream in;
if (args.length > 0) {
  in = new FileInputStream(args[0]);
} else {
  // fallback
  in = System.in;
}