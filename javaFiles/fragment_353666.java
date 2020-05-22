boolean found = false;
    for( int i=0; i<Data.length;++i){
        if(Data[i]==luck){
            System.out.println(luck+ " can be found in the following positions: ");
            System.out.println(i);
            score=score+10;
            System.out.println(luck+ " appears " +(luck/10)+ " times. You get " +score+ " points.");
            found = true;
        }
    }
    if(!found){
            Arrays.sort(Data);
            System.out.println();
            System.out.println(luck+ " is not in the array.");
            System.out.println("Hint: " +Data[0]+ " is the lowest value and " +Data[19]+ " is the highest.");
            input1 = JOptionPane.showInputDialog("Please enter another number between 0 and 100.");
            luck=Integer.parseInt(input1);
        }