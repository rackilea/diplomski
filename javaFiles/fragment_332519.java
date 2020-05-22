//This is me using the methods
case 3:
    meth.print();
    System.out.println("What is the first index you would like to swap:"); 
    int first = in.nextInt();
    System.out.println("What is the second index you would like to swap:");
    int second = in.nextInt();
    meth.reorder(first, second);
    break;