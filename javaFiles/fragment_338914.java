// trim digits from end
    System.out.println(
        "123a456z789".replaceAll("\\d+\\Z", "")
    );
    // 123a456z

    // trim digits from beginning
    System.out.println(
        "123a456z789".replaceAll("\\A\\d+", "")
    );
    // a456z789

    // trim digits from beginning and end
    System.out.println(
        "123a456z789".replaceAll("\\A\\d+|\\d+\\Z", "")
    );
    // a456z