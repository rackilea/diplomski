Scanner inRead = null;
    float sum = 0;
    int count = 0;
    while(true){
        try{
            inRead = new Scanner(System.in);
            sum+= inRead.nextFloat();
            if(count == 1) {
                count = 0;
            }
        }
        catch (InputMismatchException e){
            if (count == 1){
                System.out.println(sum);
                break;
            }
            else{
                inRead = null;
                count+=1;
            }
        }
    }