while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
        if (null != matcher.group(1)) {
            System.out.println("Level 1");
        } else if (null != matcher.group(2)) {
            System.out.println("Level 2");
        } else if (null != matcher.group(3)) {
            System.out.println("Level 3");
        } else {
            System.out.println("Level 4");
        }   
}