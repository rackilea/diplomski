public void getWoodSoldRecently(){
Calendar cal = Calendar.getInstance();
cal.add(Calendar.WEEK_OF_YEAR, -2);
for(Tree t : theTrees){
    if(t.getSimpleDateSold().getTime().after(cal.getTime()) && t.getHasBeenSold()==true){
        treesSold.add(t);
        System.out.println(t.getTreeId() + " " + t.getTreeType());
    }
    else{
        System.out.println("Nothing sold in the last 2 weeks");
        return; //Exit function
    }
}