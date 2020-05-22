short[] buffer=new short[(int)(byteData.length/2.)+1];
j=0;
for(i=0; i<byteData.length-1; i+=2) {
  buffer[j]=(short)((byteData[i]<<8)|byteData[i+1]);
  j++;
}