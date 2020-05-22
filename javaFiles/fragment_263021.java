public static void main(String[]args) {




  ArrayList myArray = array();
Collections.shuffle(myArray);
        for(int i = 27; i > 0; i-- ){
        System.out.println("Input the case number that you would like, the numbers are between 1 and 26");
        Scanner input = new Scanner(System.in);

    int casenum = input.nextInt();
    System.out.println(myArray.get(casenum));


    }

}


public static ArrayList array(){
    ArrayList list = new ArrayList();
    list.add(001);
    list.add(1);
    list.add(5);
    list.add(10);
    list.add(25);
    list.add(50);
    list.add(75);
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(750);
    list.add(1000);
    list.add(5000);
    list.add(10000);
    list.add(25000);
    list.add(50000);
    list.add(75000);
    list.add(100000);
    list.add(200000);
    list.add(300000);
    list.add(400000);
    list.add(500000);
    list.add(750000);
    list.add(1000000);




    return list;