int l = 0;
String txtstring = "<html>";
for(int i = 0; i<textArray.length ; i++){
    if(Integer.parseInt(placement[l])==i){
        l++;
        txtstring = txtstring + "<font color = red>" + textArray[i] + "</font>" + " ";
     } else {
        txtstring = txtstring + textArray[i] + " ";
    }
}
txtstring = txtstring + "</html>";