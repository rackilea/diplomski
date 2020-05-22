Files.walk(Paths.get("/home/joost"), 1).forEach(p -> System.out.println(p.toString()));

/home/joost
/home/joost/someRegularFile.jpg
/home/joost/.profile
...