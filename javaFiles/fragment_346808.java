File f = new File("F:/some_text_file.txt"); // input your text file here
    if(f.exists()){
        try{    
            Scanner sc = new Scanner(f);
            int max = Integer.MIN_VALUE;
             int min = Integer.MAX_VALUE;
             int temp=0, i=0;
             double sum=0;
            while(sc.hasNextInt()){
                temp = sc.nextInt();
                if(temp>max) max = temp;
                if(temp<min) min =temp;
                sum+=(double) temp;
                i++;

            }
            System.out.println("average : " +sum/i);    
            System.out.println("large : "+max);
            System.out.println("small :"+min);
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }       
    }