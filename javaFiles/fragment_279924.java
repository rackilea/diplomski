Iterator <String> iterKey = entries.keySet().iterator();
Iterator <Double> iterVal = entries.values().iterator();
while (iterKey.hasNext()){
  String keyVal = iterKey.next();
  Double Value = iterVal.next();

  if (getString.equals(keyVal)){
    Double temp = Value;
    if (temp==0){
      temp=0.00000001;
    }

    Double seqVal = Math.abs(Math.log10(temp));                         
    tempVal.put(keyVal, seqVal);
  }
}