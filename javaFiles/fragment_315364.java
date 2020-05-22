public static void main(String[] args) {
    List<String> array = getCoordinates(0,0,2);
    List<String> rotated = new ArrayList<String>();

    prnt(array); // original

    for(int b = 0;b < 5;b++){
        int index = 20+b;
        for(int a = 0;a < 5;a++){
            rotated.add(array.get(index));
            index -= 5;
        }
    }

    prnt(rotated); // 2nd rotation

    Collections.reverse(array);

    prnt(array); // 3rd rotation

    Collections.reverse(rotated);

    prnt(rotated); // 4th rotation
}

private static void prnt(List<String> rotated) {
    int i = 0;
    for(String line : rotated){
        if(i == 4){
            System.out.println(line);
            i = -1;
        }else{
            System.out.print(line + " ");
        } 
        i++;
    }
}