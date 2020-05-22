public  class MyObject {
static class BetterList extends ArrayList<String>{
     void someInternalLogic(){
        //
    }
}
private BetterList internalList1=new BetterList();
public List<String> getList1(){
    internalList1.someInternalLogic();
    return internalList1;
}


private List internalList2=new ArrayList<String>();
public List<String> getList2(){
    return internalList2;
}