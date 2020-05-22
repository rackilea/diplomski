boolean f1=false, f2=false, f3=false;
while(true) {
    f1=false; f2=false; f3=false;
    for(i=0; i<wc; i++)
    for(j=0; j<hc; j++) {
      int p=bim.getRGB(i, j);
      int p1=(p&0x00ff0000)>>16, p2=(p&0x0000ff00)>>8, p3=p&0x000000ff;
      if(p1>avg[i+j*wc]+10) { p1-=10; if(p1<avg[i+j*wc]) p1=avg[i+j*wc]; f1=true; }
      else if(p1<avg[i+j*wc]-10) { p1+=10; if(p1>avg[i+j*wc]) p1=avg[i+j*wc]; f1=true; }
      if(p2>avg[i+j*wc]+10) { p2-=10; if(p2<avg[i+j*wc]) p2=avg[i+j*wc]; f2=true; }
      else if(p2<avg[i+j*wc]-10) { p2+=10; if(p2>avg[i+j*wc]) p2=avg[i+j*wc]; f2=true; }
      if(p3>avg[i+j*wc]+10) { p3-=10; if(p3<avg[i+j*wc]) p3=avg[i+j*wc]; f3=true; }
      else if(p3<avg[i+j*wc]-10) { p3+=10; if(p3>avg[i+j*wc]) p3=avg[i+j*wc]; f3=true; }
      bim.setRGB(i, j, 0xff000000|(p1<<16)|(p2<<8)|p3);
    }
    if(f1 || f2 || f3) ; else   {    System.err.println("no change"); break; }
}