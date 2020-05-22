Signal [] sig= {a1a2a3, b1b2b3, c1c2c3, d1d2d3};
for(int i = 0;i<sig.size();i++){
for(int j = 0;j<sig[i].length() ;j++){
newArray.add(sig.subString(j,j+1));
}
}