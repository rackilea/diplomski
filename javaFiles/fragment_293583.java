public static void main(String[] args) {
    String[] ppl = new String[]{"Karen (F)","Kevin (M)","Lee (M)","Joan (F)","Des (M)","Rick (M)"};
    int maleCount = 0;
    int femaleCount = 0;
    for (int i = 0; i < ppl.length; i++) {
        if(ppl[i].contains("(M)")){
            maleCount++;
        }
        if(ppl[i].contains("(F)")){
            femaleCount++;
        }
    }
    System.out.println("maleCount: "+maleCount);
    System.out.println("femaleCount: "+femaleCount);
    }