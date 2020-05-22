Files.lines(Paths.get("input.txt"))
     .forEach(line -> {
         Scanner s = new Scanner(line);
         s.useDelimiter(",");
         System.out.println(s.next() + " " + s.next());
     });