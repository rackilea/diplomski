@Test
public void test(){
    String original = "This is the phrase %d";
    long init = System.currentTimeMillis();
    for(int i = 0; i < 100000; i++){
        System.out.println(String.format(original, i));
    }
    long end = System.currentTimeMillis();

    long init1 = System.currentTimeMillis();
    for(int i = 0; i < 100000; i++){
        System.out.println(original.replace("%d", String.valueOf(i)));
    }
    long end2 = System.currentTimeMillis();
    System.out.println("Method 1: " + (end-init));
    System.out.println("Method 2: " + (end2-init1));
}