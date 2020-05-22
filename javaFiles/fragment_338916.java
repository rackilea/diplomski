System.out.println(
        chopPrefix("abcdef", "abc")
    ); // def

    System.out.println(
        chopSuffix("abcdef", "ef")
    ); // abcd

    System.out.println(
        chopPresuffix("abcdef", "cd")
    ); // abcdef

    System.out.println(
        chopPresuffix("abracadabra", "abra")
    ); // cad