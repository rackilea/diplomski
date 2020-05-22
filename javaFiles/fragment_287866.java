int counter = 1;
 while((lineString = br.readLine())!= null){
        if(counter == rownum){
            System.out.println(lineString);
        }
        counter++;
    }