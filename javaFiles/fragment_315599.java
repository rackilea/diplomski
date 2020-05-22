public static void main(String[] args) {

    double a = 10;
    double b = 2;
    double c = 3;
    double avg = (a + b + c)/3;

    System.out.println(avg);

    for (int i=0; i<3; i++) {
        avg = (avg + b + c)/3;
        System.out.println(avg);
    }

}