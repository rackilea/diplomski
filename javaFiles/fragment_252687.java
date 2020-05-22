String tv = "Bravia";
    String television = "Bravia";

    // String compare example using equals
    if (tv.equals(television)) {
        System.out.println("Both tv and television contains same letters and equal by equals method of String");
    }

    // String compare example in java using compareTo
    if (tv.compareTo(television) == 0) {
        System.out.println("Both tv and television are equal using compareTo method of String");
    }

    if (tv.compareTo(television) < 0){

    System.out.println("tv comes before  using compareTo method of String");
    }

if (tv.compareTo(television) > 0){

    System.out.println("tv comes after using compareTo method of String");
    }