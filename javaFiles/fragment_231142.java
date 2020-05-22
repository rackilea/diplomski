class ATest<T> {
  Map<String, String> props = new HashMap<String, String>();

  void aTest() {
    // Works fine.
    for (Map.Entry<String, String> entry : props.entrySet()) {
    }
  }

  void bTest() {
    ATest aTest = new ATest();
    // ERROR! incompatible types: Object cannot be converted to Entry<String,String>
    for (Map.Entry<String, String> entry : aTest.props.entrySet()) {
    }
  }

  void cTest(Map props) {
    // ERROR! incompatible types: Object cannot be converted to Entry<String,String>
    for (Map.Entry<String, String> entry : props.entrySet()) {
    }
  }

}