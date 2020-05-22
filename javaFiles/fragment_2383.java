static String[] expandArgs(List<StdArg> argList) {
    ArrayList<String> out = new ArrayList<>();
      // (***snip***)
            try (DirectoryStream<Path> dstream =
                    Files.newDirectoryStream(parent.toPath(), glob)) {
                int entries = 0;
                for (Path p : dstream) {
                    out.add(p.normalize().toString());
                    entries++;
                }