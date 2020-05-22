public static void SwigDirector_NativeLayerDelegate_OnMessage(
     NativeLayerDelegate self, long msg, long answer_to) {
    self.OnMessage(new Message(msg, false), answer_to);
    // false parameter means that Message object isn't owner of 'msg' pointer, so it
    // shouldn't free it on finalize.
  }