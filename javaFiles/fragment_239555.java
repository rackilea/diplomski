class TestModel {

private DefaultListModel lm_;

  public TestModel() {
    lm_ = new DefaultListModel();

    String[] testList = new String[] {"user1", "user2"};

    for(int i=0; i < testList.length; i++) {
      lm_.add(i, testList[i]);
    }
  }

  public ListModel getListModel() {
    return lm_;
  }
}

public class Test {

  public Test() {

    TestModel tm = new TestModel();

    JList list = new JList(tm.getListModel());
  }
}