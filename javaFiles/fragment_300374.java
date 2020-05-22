while (i++ < 3) {
    System.out.print("Enter The Students name  : ");
    first_name = BIO.getString();

    if (first_name.equals("END"))
        break;

    System.out.print("Their Module mark   : ");
    moduleMark = BIO.getInt();

    if (moduleMark >= 40) {
        System.out.println(first_name + " Pass");

    } else {
        System.out.println(first_name + " Fail");

}