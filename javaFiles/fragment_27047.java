String path = System.getProperty("user.dir");
      System.out.println(path + "\\disSoruCevap.txt");
      File file = new File(path + "\\disSoruCevap.txt");


      if (!file.exists()) {
          System.out.println("System couldnt file source file!");
          System.out.println("Application will explode");
      }