public class Boo {
public V doSomething(...) {
    return (Common.doSomething(...));
}
}
public class Wow {
public V doSomething(...) {
    return (Common.doSomething(...));
}
}
public class Common {
public static native V doSomething(...);
}
/** Trivial JNI Implementation omitted... */