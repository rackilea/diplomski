List<Object[]> outerList = new ArrayList<Object[]>(array.length);
for(int i = 0; i < array.length; i++) {
    Object[] inner = array[i];
    if (inner != null) {
        List<Object> list = new ArrayList<Object>(inner.length);
        for(int j=0; j < inner.length; j++){
            if(inner[j] != null){
                list.add(inner[j]);
            }
        }
        outerList.add(list.toArray(new Object[list.size()]));
    }
}
array = outerList.toArray(new Object[outerList.size()][]);