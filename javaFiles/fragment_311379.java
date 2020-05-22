while(totalRead<size){
        System.out.println("-----------append number "+j+"----------");
        System.out.println("totalRead="+totalRead);
        //I suspect this is unnecessary and one source of the error
        //this loop would overwrite data from the last iteration's tmpData
        for(int i=0;i<tmpData.length;i++){ 
            finalData[i]=tmpData[i];
        }
        tmpData = new byte[size-totalRead];
        int tmpRead = bis.read(tmpData, 0, size-totalRead);
        System.out.println("tmpRead="+tmpRead);
        for(int i=0;i<tmpData.length;i++){
            finalData[i+totalRead]=tmpData[i];  //append tmpData
        }
        totalRead+=tmpRead;
        j++;
    }