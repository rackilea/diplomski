String str;
Float min =Float.valueOf(Float.POSITIVE_INFINITY );
for(Map.Entry<String,Float> e:distance.entrySet()){
    if(min.compareTo(e.getValue())>0){
        str=e.getKey();
        min=e.getValue();
    }
}