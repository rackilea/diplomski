final DateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
    final File file = new File("G:\\TestFiles");

    for (File subDir : file.listFiles()) {
      System.out.println(simpleDateFormat.format(Files.readAttributes(file.toPath(), BasicFileAttributes.class)
          .creationTime().toMillis())
      );
    }