Scanner input = new Scanner(System.in);
    String mail = "@gmail.com";
    System.out.println("Enter names: ");
    String names = input.next();
    if(names.contains(",")) {
            for(String name : names.split(",")) {
                    System.out.println(name + mail);
            }
    } else {
            System.out.println(names + mail);
    }