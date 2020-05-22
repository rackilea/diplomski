while(sken.hasNext())
    {

        String thisLine = sken.nextLine();
        if(thisLine.equals("exit")){
            break;
        }
        String[] line =thisLine.split(",");
        String name= line[1];
        int howOld= Integer.parseInt(line[0]);
        hashMap.put(howOld, name); 
    }