public static int getCustomerIndex(String name){
    for (int q = 0; q < nArray.size(); q++){
        if (name.equals(nArray.get(q))){
            return q;
        }
    }
    return -1;
}

public static void displayCustomer(int index){
    System.out.println("Name: " + nArray.get(index));
    System.out.println("Phone #: " + pArray.get(index));
    System.out.println("Email: " + eArray.get(index));
}