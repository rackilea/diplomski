public static void main(String[] args) {
    Random gen= new Random();
    int[] ages = new int[10];
    List<Integer> agesLesserThan40 = new ArrayList();
    List<Integer> agesLesserThanAverage = new ArrayList();
    float value = 0;

    for(int i=0; i<10; i++) {
        ages[i] = gen.nextInt(100);
        value += ages[i];
    }

    for(int x=0; x<10; x++){
        if(ages[x] < value/10) agesLesserThanAverage.add(ages[x]);
        if(ages[x] < 40) agesLesserThan40.add(ages[x]);
    }

    System.out.println("ages:");
    for(int z=0; z<10; z++){System.out.print(ages[z] + ", ");}
    System.out.println();
    System.out.println("Lesser than 40: ");
    for(int y=0; y<agesLesserThan40.size()-1; y++){System.out.print(agesLesserThan40.get(y) + ", ");}
    System.out.println();
    System.out.println("Lesser than average: ");
    for(int y=0; y<agesLesserThanAverage.size()-1; y++){System.out.print(agesLesserThanAverage.get(y) + ", ");}
    System.out.println();

    System.out.println("The average value of the integers is " + value / 10 + ".");
    System.out.println("The combined value of the integers is " + value + ".");
}