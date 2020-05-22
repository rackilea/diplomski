public static class ClientSetting<T> {
   private T setting;

   ClientSetting(T setting) {
      this.setting = setting;
   }

   public T get() {
      return setting;
   }
}

// Old school, I know.
public static final ClientSetting<String> SOME_STRING_SETTING = 
   new ClientSetting<String>("My string value.");
public static final ClientSetting<Integer> SOME_INTEGER_SETTING = 
   new ClientSetting<Integer>(2);

public static <T> T get(ClientSetting<T> clientSetting) {
   // delegation, this method is not really needed
   // you can go for SOME_STRING_SETTING.get()
   return clientSetting.get();
}

public static void main(String[] args) {
   String stringValue = get(SOME_STRING_SETTING);
   Integer integerValue = get(SOME_INTEGER_SETTING);
   // Won't compile
   // String wrong = get(SOME_INTEGER_SETTING);
}