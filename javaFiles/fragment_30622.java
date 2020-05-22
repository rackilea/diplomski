int a,b;
if(dmg_cyl_recvd.getText() != null && !dmg_cyl_recvd.getText().trim().equals("")) // also put it in try-catch for the case the input is not numeric
try{
    a=Integer.parseInt(dmg_cyl_recvd.getText().toString());
}catch(NumberFormatException ex){
//alert user about wrong input
}
if(Util.DAMAGE_LIST.size() > 0)//assuming it is a list, if not use method that gives the size of corresponding collection
    b=Integer.parseInt(Util.DAMAGE_LIST.get(0).toString());