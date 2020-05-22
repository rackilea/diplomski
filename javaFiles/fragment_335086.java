differentArray= new int[n];
for (int i = 0; i < differentArray.length; i++) {
    int value = 0;
    while(true){
        value = (int)(Math.random()*max);
        boolean found = false;
        for(int p: differentArray){
            if(p==value){
                found = true;
                break;
            }
        }
        if(!found) break;
    }
    differentArray[i] = value;
}