File myMusic = new File(oldFiles + File.separator + "My Music");
    System.out.println(myMusic);
    System.out.println(myMusic.isDirectory());
    System.out.println(myMusic.isAbsolute());
    System.out.println(myMusic.isHidden());
    System.out.println(myMusic.getCanonicalFile());
    System.out.println(myMusic.getAbsoluteFile());

    File[] lstFiles = myMusic.listFiles();
    if (lstFiles == null) {

        System.out.println("Can not list...");

    } else {

        for (File file : lstFiles) {

            System.out.println(file);

        }

    }