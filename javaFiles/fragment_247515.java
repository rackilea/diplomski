String inputValue = " ";
    String inputArr[] = new String[13];
    String answerKey = null;
    String numStudents[];

    InputStreamReader ISR = new InputStreamReader(System.in);
    BufferedReader BR = new BufferedReader(ISR);

    try {
        inputValue = BR.readLine();
        String answers[] = inputValue.split(" "); 
        int count = 0;
        System.out.println();
        while((inputValue = BR.readLine()) != null) {
            if (inputValue.equalsIgnoreCase("ZZZZ"))
                break;
            inputArr = inputValue.split("\\s+");
            System.out.print(inputArr[2] + " ");
            System.out.print(inputArr[1] + " ");
            System.out.print(inputArr[0].split(",")[0] + " ");
            count = 0;
            for(int i = 0; i <10; i++){
                if(inputArr[i+3].equalsIgnoreCase(answers[i+1]))
                    count ++;
            }
            System.out.print(count);
            System.out.println();
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }      

}