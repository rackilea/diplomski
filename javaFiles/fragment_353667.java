public static void main(String[] args) {
    int Data[] = new int [20];
    for( int i=0; i<Data.length;++i){
        Data[i] = (int) (Math.random() * 100);
        System.out.print(Data[i]+ " \t");
    }

    while(true){
        String input1 = JOptionPane.showInputDialog("Please enter your lucky number between 0 and 100.");
        int luck=Integer.parseInt(input1);
        int score = 0;
        String positions = "";
        int counter = 0;
        System.out.println("Input " +luck);

        boolean found = false;
        for( int i=0; i<Data.length;++i){
            if(Data[i]==luck){
                positions +=  i + " ";
                counter++;
                score=score+10;
                found = true;
            }
        }
        if(found){
            System.out.println(luck+ " can be found in the following positions: ");
            System.out.println(positions);
            System.out.println(luck+ " appears " + counter + " times. You get " +score+ " points.");

        }
        else{
            Arrays.sort(Data);
            System.out.println();
            System.out.println(luck+ " is not in the array.");
            System.out.println("Hint: " +Data[0]+ " is the lowest value and " +Data[19]+ " is the highest.");
        }

        System.out.println();
        System.out.println("Score: " +score);
    }

}