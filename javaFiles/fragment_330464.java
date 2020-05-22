for(Object[] data : stocks){
    Inventory iv = new Inventory();
    iv.setMedcineID((Integer) data[0]);
    iv.setMName((String) data[1]);
    iv.setQuantity((Integer)data[2]);
    allResults.add(iv);
}