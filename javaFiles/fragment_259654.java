public class HelloJni
{
    public native String  stringFromJNI();

     static {
        System.loadLibrary("hello-jni");
    }
}