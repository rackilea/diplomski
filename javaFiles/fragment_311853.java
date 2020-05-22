Map<SomeObject,int> frequencymap = new HashMap<SomeObject,int>();
 foreach(SomeObject element in objectList) {
    if(frequencymap.containsKey(element)) {
      frequencymap.put(element , frequencymap.get(element)+1);
  }
 else{ frequencymap.put(element, 1); }
}