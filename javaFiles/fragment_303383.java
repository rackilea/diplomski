public class MyClazzWrapper {
    public MyClazzWrapper(MyClazz myClazz) {
        this.myClazz = myClazz;
    }
    @SerializedName("PARAM")
    private MyClazz myClazz;
}