public Vector measureArea(int[] pix, int color) {
    int i;
    Vector v=new Vector();
    int c=color&0x00ffffff;
    for(i=0; i<pix.length; i++)
      if((pix[i]&0x00ffffff)==c) v.add(i);
    return v;
  }