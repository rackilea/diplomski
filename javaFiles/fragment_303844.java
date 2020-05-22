while (true) {
    System.out.println("Pleaste enter your age");
    customerAge = sc.nextInt();
    if (customerAge < 18) {
        System.out.println("You can not proceed without parent supervision as you are under the age of 18 !");
        continue;
    }    
    break;
}