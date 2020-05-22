final String xs = "0001254200";
    int i = xs.length() - String.valueOf(Integer.parseInt(xs)).length();
    System.out.println(i);

    //Another option based on Titus comment

    i = xs.length() - xs.replaceAll("^0+", "").length();
    System.out.println(i);