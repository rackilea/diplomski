public static void main(String[] args) {
    newclass [] NC;
    NC = new newclass[2];

    int x=5, y=5;
    for (int i=0 ; i<2 ; i++){
        NC[i]= new newclass(x,y);
    }

    //solve roomHC
    for (int i=0 ; i<2 ; i++){
        NC[i].storedata();
    }

    //display solution
    for (int i=0 ; i<2 ; i++){
        System.out.print("\n");
        NC[i].display();
        System.out.print("========================");
    }
}