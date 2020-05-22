while(input.hasNext()){     // read line by line 

        s = input.nextLine();
        s=s.replaceAll(" ", "");
        if(s == null)
        continue;
        else{

            temp1 =s.split(",");
            //companies[x] is still null - initialize this!
            companies[x] = new Company();
            //Now this should be fine
            companies[x].compName=temp1[0];           //store compName in the companies
            for( i=1;i<temp1.length;i++){