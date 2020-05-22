111     private transient Object[] elementData;

...

336     @SuppressWarnings("unchecked")
337     E elementData(int index) {
338         return (E) elementData[index];
339     }