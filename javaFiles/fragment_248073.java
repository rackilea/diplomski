String[] B = {"2", "14", "5", "12", "10"};
    String[] I = {"20", "25", "18", "16", "22"};
    String[] N = {"42", "32", "FREE", "31", "39"};
    String[] G = {"60", "55", "53", "46", "59"};
    String[] O = {"64", "70", "67", "75", "71"};

    String[][] test={B,I,N,G,O};
    int n=0;
    System.out.println("B  I  N  G  O");
    for(String[] str:test){
         for(int i=0;i<str.length;i++){
             System.out.print(test[i][n] + " ");
         }
        System.out.println("\n");
        n++;
    }