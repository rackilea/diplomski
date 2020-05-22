Object obj = in.readObject();
if (obj instaneof MyClass) {
    MyClass c = (MyClass) obj;
    process(c);
} else if (obj instanceof MyOtherClass) {
    // etc