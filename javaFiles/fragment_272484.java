class ScopeTest {

public static void main(String[] args) {

TestModel testModel;
Map<String, TestModel> myModel = new HashMap<String, TestModel>();//Use TestModel
                                                                instead of object

for (int i=1; i<2; i++){ 
    testModel = new TestModel();
    testModel.setText("test text");
    myModel.put("test", testModel);
    }

for (Entry<String, TestModel> entry : myModel.entrySet()) {
    String key = entry.getKey();
    TestModel value = entry.getValue();
    System.out.println("key=" + key); 
    System.out.println("value.getText()=" + value.getText()); 
}
}
}