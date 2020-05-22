public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int current=0, max = 10;
    video[] varray = new video[max];
    for(int j = 0; j < 3; j++) {
        video v = new video();
        v.addVideo();
        varray[j]=v;
        current++;  
    }
    printAll(current, varray);  
}