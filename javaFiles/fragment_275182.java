String[] nLine = iLine.split(" ");
   if(nLine[0].equals("DATE") && flag == 0){

    for (int i=0; i<86400; i++){
    varCount[i] = 0;
    varValue[i] = 0;
    }

    flag = 1;

   }
   else if(nLine[0].equals("DATE") && flag == 1){

    for (int i=0; i<86400; i++){
    if (varCount[i] != 0){
    varValue[i] /= varCount[i];
    }
    }

    varValue = fillBlankSpreads(varValue, 86400);

    avgData.add(varValue.clone());

    flag = 0;

   }
   else{

    n = Integer.parseInt(nLine[0])-1;

    varValue[n] += Double.parseDouble(nLine[2]);
    varCount[n] += 1;

   }