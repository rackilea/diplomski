[...]
for(int i=0; i<txtF.size();i++){
    Column col = new Column(); // Declaration moved to here
    col.setName(txtF.get(i));
    //System.out.println("NAMEE: "+txtF.get(i));
    col.setType(comboF.get(i));
    //System.out.println("Type: "+comboF.get(i));
    cols.add(col);
}
[...]