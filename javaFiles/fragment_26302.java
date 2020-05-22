for (int i = 0; i < items.length; i++) {
    boolean added=false;    
    for(Bin bin: list){ 
        if(bin.addItem(items[i])){
            added=true;         
            break;
        }
    }
    if(!added){
        Bin bin=new Bin();
        bin.addItem(items[i]);
        list.add(bin);
    }
}
return list;