for(int i=0; i<x; i++){

    if(numberPair[0][i]<numberPair[1][i]){
        //a minimum
        solution[i] = numberPair[0][i];
    }
    else {
        //b min
        solution[i] = numberPair[1][i];
    }

}

//this part was inside calculating loop
for(int j=0; j<x; j++)
    System.out.println(solution[i] + " ");