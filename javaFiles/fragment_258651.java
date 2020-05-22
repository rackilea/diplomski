public Vector measureArea(int[] pix) {
    int i;
    Vector v=new Vector();
    for(i=0; i<pix.length; i++)
      if((pix[i]&0x00ffffff)==0x00000000) v.add(i);
    return v;
  }