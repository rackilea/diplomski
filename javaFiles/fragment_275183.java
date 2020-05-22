}

private double[] fillBlankSpreads(double[] varValue, int numSpread){
//Filling the Data with zeros to make the code faster
 for (int i=1; i<numSpread; i++){
 if(varValue[i] == 0){
 varValue[i] = varValue[i-1];
 }
 }

 return varValue;
}