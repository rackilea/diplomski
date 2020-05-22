boolean flag=true; //condition
   while (flag){

     switch (counter) {
        case (1):
            System.out.println ("case 1");
            break;
        case (2):
             System.out.println ("case 2");
            break;
        case (3):
              System.out.println("case 3");
            break;
        default:
            ArrayList<String[]> arrayL= new ArrayList<>();
            while ((line = br.readLine()) != null){
                //System.out.println(line);
                String[] splitter= line.split(" ");
                arrayL.add(splitter);
            }//
            mainArray= new String[arrayL.size()][arrayL.get(0).length];
            for(int i = 0; i<mainArray.length; i++) {
                for(int j=0; j<mainArray[0].length;j++)
                        mainArray[i][j] = arrayL.get(i)[j]; 
            } //for
         break;
        }//switch
       counter++;

       //for example, we can interrupt the cycle 
       flag=false; //You must set your own condition!
   }//while