public enum Types {

    KEY1(MyMessageConstant.VAL1), KEY2(MyMessageConstant.VAL2),...
    KEY4(MyMessageConstant.VAL2),

    private static final class MyMessageConstant {        
       private static final String VAL1 = "Val2";
       private static final String VAL2 = "Val2";        
       private MyMessageConstant() {}
    }

    private String value;

    private Types(String value) {
      this.value = value;
    }

}