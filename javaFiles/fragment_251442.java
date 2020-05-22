System.out.println("NOMZ".matches("NOMZ??"));
    // "true"

    System.out.println(
          "NOM NOMZ NOMZZ".replaceAll("NOMZ??", "YUM")
    ); // "YUM YUMZ YUMZZ"