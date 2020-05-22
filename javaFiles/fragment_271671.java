for (int i=num; i>0; --i){
    //Insert spaces in order to center the diamond
    for (int n=0; n<i; ++n){
        System.out.print(" ");
    }
    System.out.print("*");
    for (int n=i; n<num; ++n){
        System.out.print("$*");
    }//Ending bracket of nested for loop
    System.out.println();
}//Ending bracket of for loop
//Print out a diamond shape based on user input
for (int i=0; i<=num; ++i){   //<= to print the last asterisk
    //Insert spaces in order to center the diamond
    for (int n=0; n<i; ++n){
        System.out.print(" ");
    }
    System.out.print("*");
    for (int n=i; n<num; ++n){
        System.out.print("$*");
    }//Ending bracket of nested for loop
    System.out.println();
}//Ending bracket of for loop