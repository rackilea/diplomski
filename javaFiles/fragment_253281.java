//note that I have removed the "throws" from the method declaration
public static void f2_1(int x) {
    try {
        f1(x);
    } 
    catch (XisFiveException e) {
        f1(x + 1);
    }
}