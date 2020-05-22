class Element implements Comparable<Element>{
     String value, label; // label is a1,a2,a3....; value is whatever other data you want to store
      int sequence;// used for sorting 
      public int compareTo(Element o)          {
  return this.sequence- o.sequence;
}
}