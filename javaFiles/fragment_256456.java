for(int i=0; i<=2;i++){
    temp = new Vector<Integer>();//initialize every time. Do you really need Vector or list will work?

    for(int j=0; j<=4;j++){
        temp.add(i*j);
    }                   
    setA.add(temp);//do you  really need vector within vector?