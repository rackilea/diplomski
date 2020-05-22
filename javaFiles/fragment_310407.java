int[] avg=new int[pix.length];
  for(i=0; i<wc; i++)
    for(j=0; j<hc; j++) {
      int p=bim.getRGB(i, j);
      int p1=(p&0x00ff0000)>>16, p2=(p&0x0000ff00)>>8, p3=p&0x000000ff;
      avg[i+j*wc]=(p1+p2+p3)/3;
    }