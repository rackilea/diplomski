public static void main(String[] args) {
    int [] counts = {6, 4, 10};
    String [] names = {"Alis", "Pop", "Fred"};
    System.out.println(Arrays.toString(counts));
    System.out.println(Arrays.toString(names));
    int newCount = 15;
    String newUser = "Jhon";
    int min = counts[0], position = 0;
    for(int i = 1 ; i < counts.length; i++)
        if(counts[i] < min){
            min = counts[i];
            position = i;
        }
    if(min < newCount){
        counts[position] = newCount;
        names[position] = newUser;
    }
    System.out.println(Arrays.toString(counts));
    System.out.println(Arrays.toString(names));
}