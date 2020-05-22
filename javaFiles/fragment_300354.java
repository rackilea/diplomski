while(num != 0){

        if(num < 0)
            countpos++;
        else
            countneg++;

        total = total + num;
        totalnum++;

        num = input.nextInt();
    }