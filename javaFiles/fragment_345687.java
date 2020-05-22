boolean isLetter(char let){
        return ( let>= 'a'&& let <= 'z') || ( let >= 'A' && let <='Z');
}

public static void main(String args[]){
    File file_in_obj = new File("E:/Problems","notes.txt");
    File file_out_obj = new File("E:/Problems","notes_sorted.txt");
...
}