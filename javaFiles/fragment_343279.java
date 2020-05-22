public static void main(String[] args) {
    String s = "abc,xyz,lmn,ijk";
    char[] ch = s.toCharArray();
    int counter = 0;
    int place = 2;

    for (int i = 0; i < ch.length-2; i++) {
        if(ch[i] == ',') {
            counter++;
        }
        if(counter == place && ch[i] != ',') {
            System.out.print(ch[i]);
        }
    }
}