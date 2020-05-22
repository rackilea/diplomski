static void test() { 
    Locale.setDefault(Locale.US);
    double start = 1.0;
    double x=start;
    for(int i=0;i<367;i++) {
        System.out.println(sprintfDouble5(x));
        x*= -7.0;
    }
    x=start;
    for(int i=0;i<6;i++) {
        System.out.println(sprintfDouble5(x));
        x/= -5;
    }
    for(int i=0;i<200;i++) {
        System.out.println(sprintfDouble5(x));
        x/= -42.01;
    }
    x=Math.PI*0.0000001;
    for(int i=0;i<20;i++) {
        System.out.println(sprintfDouble5(x));
        x*=10;
    }
    System.out.println(sprintfDouble5(0.0));
    System.out.println(sprintfDouble5(-0.0));
    System.out.println(sprintfDouble5(0.0/0.0));
}