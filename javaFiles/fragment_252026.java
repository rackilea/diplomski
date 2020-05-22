for(int i=0;i < buff.length;i++) {
  if (i == buff.length) {
    // But this is only an hint to perform garbage as soon as possible
    System.gc();
    i = 0;
  }
  Integer obj = new Integer(i); // line 14
  buff[i] = obj;
  // do something useful with buff[i];
}