double sum = 0;
String ret = "";
for(int i = 0; i< kassenZettel.size(); i++){
  ret += kassenZettel.get(i).toString()+"\r\n";
  sum += kassenZettel.get(i).getPreis();
}
ret += "\r\nSumme: "+sum;