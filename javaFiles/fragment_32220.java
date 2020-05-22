Double getBar(MyType type,  Map<MyType,Double> map){  
    if(map.containsKey(type)){   
         for(MyType k:map.keySet()){  
              if(k.equals(type)){  
                 return k.bar;  
              }
         }
    }
    return -1.0;
}