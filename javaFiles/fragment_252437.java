public /* abstract */ class MyParentObjectServiceImpl<T extends MyParentObject>
  implements MyParentObjectService{

  MyParentObjectServiceImpl(Class<T> type) { this.type = type; }

  private final Class<T> type; // subclasses provide this

  @Override
  public T findObjectByProp(String prop){
    //you can use type for object specific stuff
  }
}

public class MyObjServiceImpl extends MyParentObjectServiceImpl<MyObj>
  // You might not need this interface anymore 
  // if the only method defined is findMyObjByProp
  /* implements MyObjectService */ {
  MyObjServiceImpl() {
    super(MyObj.class);
  }

  @Override
  public /* final */ MyObj findMyObjByProp(String prop) {
    return (MyObj) super.findObjectByProp(prop, this.myObjType);
  }
}