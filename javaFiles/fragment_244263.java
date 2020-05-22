Pattern p = Pattern.compile("^AAB/CC/(.+)/DD/(.+?)-(.+?)-(.+?)-(.+?)$");

try (Scanner scan = new Scanner(example2);) {
      scan.findAll(p)
          .map(mr -> new A(mr.group(1), mr.group(2), mr.group(3), mr.group(4), mr.group(5)));
}