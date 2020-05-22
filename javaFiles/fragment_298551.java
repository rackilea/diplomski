public class BaseInfoClass {
    public static brandStringList[];
    public static Alert_typesStringList[];
    public static VideoStringList[];
}

private LinkedList<BaseInfoClass> mAllInfo;  //  Init this as you need with lg0, etc.

public void whateverMethod() {
    for (BaseInfoClass curClass : mAllInfo) {
        for (int i = 0; i < curClass.brandStringList.length; i)) {
            MobileInformation newInfo = new MobileInformation();
            mobile.Alert_types = curClass.Alert_typesStringList[i];
            .
            .
            .
            mobile.Video = curClass.VideoStringList[i];          
        }
    }
}