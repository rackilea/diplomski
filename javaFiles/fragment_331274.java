import java.util.ArrayList;

public class IntSLList {
  protected int head,tail;
  //I'll use this as examplelist, so I can omit the list implementation
  private ArrayList<Integer> dataList;

  public IntSLList(){
    //Do initalization
    dataList = new ArrayList<>();
  }

  public void addToHead(int node){
    dataList.add(0, node);
  }

  public void addToTail(int node){
    dataList.add(node);
  }

  public boolean isEmpty(){
    return dataList.isEmpty();
  }

  // ... snip other list methods here ...

}