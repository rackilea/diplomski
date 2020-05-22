for(int i=0;i<=list.length-4;i++){
    for(int j=i+1;j<=list.length-3;j++){
        for(int k=j+1;k<=list.length-2;k++){// change i+2 to j+1
            for(int l=k+1;l<=list.length-1;l++){// change i+3 to k+1
                System.out.println(list[i]+","+list[j]+","+list[k]+","+list[l]);
            }
        }
    }
}