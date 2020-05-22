public static void main(String[] args){
    java.util.Scanner input=new java.util.Scanner(System.in);

    System.out.print("Enter the number of students: ");
    int n1=input.nextInt();
    int [] number=new int[n1];

    System.out.print("Enter "+n1+" Scores: ");
    for (int i = 0; i < number.length; i++) {
        number[i]=input.nextInt();
        int b=i+1;
        System.out.println("Score "+b+": "+number[i]);

    }
    int best = number[0];
    for (int i = 0; i < number.length; i++) {

        if (number[i]>best) best = number[i];
    }
    System.out.println("The best score is: "+best);

    for (int i = 0; i < number.length; i++) {
        if(number[i]>=best-20 && number[i]<=best-10) System.out.println("For score "+number[i] +" you get B grade.");
        if(number[i]>=best-30 && number[i]<=best-20) System.out.println("For score "+number[i] +" you get C grade.");
        if(number[i]>=best-40 && number[i]<=best-30) System.out.println("For score "+number[i] +" you get D grade.");
    }


}
}`