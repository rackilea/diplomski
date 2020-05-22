Scanner input = new Scanner(new File("someText.txt"));
int count = 0;

while(input.hasNext() && count <= 30){
    count++;
    String word = input.next();

    if (count == 12){
        System.out.println(word);
    }
    if (count == 30){
        System.out.println(word);
    }
}