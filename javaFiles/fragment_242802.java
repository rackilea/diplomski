while (true) {
     System.out.println("What do you want me to do with these numbers?");
        operation = finalProduct.nextLine();

        if (operation.equals(Multiply)){

            System.out.println(fnum * snum);
            break;

        }else{

            System.out.println("I do not recognize this operation");

        }
     }