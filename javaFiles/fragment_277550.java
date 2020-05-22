String[] split = productLine.split(" ");
String amount="split[0];
String product = "";
for(int i = 0: i < split.length-3; i++){ 
     if(i > 0 ){ //adding spaces
         product = product + " ";
     }
     product = product + split[i+1];
}
String unitPrice=split[split.length-2];
String total=split[split.length-1]