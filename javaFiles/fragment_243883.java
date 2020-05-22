for(int i=0; (i=br.read())>-1;){
    tempLigne = br.readLine().split(" ");
    for(int j=0; j<tempLigne.length; j++){
        if(tempLigne[j].equals("0")){
            countZeros++;
        }else if(tempLigne[j].equals("1")){
            countOnes++;
        }
    }
}