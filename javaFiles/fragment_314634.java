Path file = Paths.get("/Music/Beatles/Help.mp3");

Path dir1 = Paths.get("/");
Path dir2 = Paths.get("/Music");
Path dir3 = Paths.get("/Music/Beatles");

System.out.println(dir1.relativize(file));
System.out.println(dir2.relativize(file));
System.out.println(dir3.relativize(file));