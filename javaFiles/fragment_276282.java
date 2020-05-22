class newClass {
 enum Colors {RED,GREEN,BLACK}

 public static Image getBlock(Colors colors) {
    switch (colors){
        case BLACK:
            System.out.println("BLACK");;
            break;
        case GREEN:
            System.out.println("GREEN");;
            break;
        case RED:
            System.out.println("RED");
            break;
            default:
                System.out.println("non color");
    }
}