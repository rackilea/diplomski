// Native
void SwigDirector_NativeLayerDelegate::OnMessage(Message msg, Long answer_to) {
  ...
  *((Message**)&jmsg) = new Message(msg);
  ...
  jenv->CallStaticVoidMethod(..., jmsg, ...);
  ...
}

// Java
public static void SwigDirector_NativeLayerDelegate_OnMessage(
     NativeLayerDelegate self, long msg, long answer_to) {
    self.OnMessage(new Message(msg, true), answer_to);
}