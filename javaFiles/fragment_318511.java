public interface MyLib {
  MyStruct get_my_struct();
}

public static void main(String[] args) {
  MyLib mylib = LibraryLoader.create(MyLib.class).load("mylib.so");
  MyStruct myStruct = mylib.get_my_struct();
  System.out.printf("%d %s are %s, %s", myStruct.classes.get(), myStruct.names.get(),
      myStruct.names2[0].get(), myStruct.names2[1].get());
}