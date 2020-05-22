public enum InnerEnum {
    OPTION1("someData"),
    OPTION2("otherData");

    final String data;

    InnerEnum(String data) {
       this.data = data;             
    }

    void callOuterMethod(OuterClass oc) {
        oc.outerMethod(data);
    }
}