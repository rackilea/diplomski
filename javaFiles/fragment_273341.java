public calendar() {
    int day = 2;
    int numOfDays = 28;

    System.out.println("S  M  T  W  T  F  S");
    for(int i = 1; i < day; i++){
        System.out.print("   ");
    }
    for(int i = 1; i <= numOfDays; i++){
        System.out.print(addSpaces(i + "", 3));
        if((i + day - 1) % 7 == 0){
            System.out.print("\n");
        }
    }
}

public String addSpaces(String s, int length){
    while(s.length() < length){
        s+= " ";
    }
    return s;
}