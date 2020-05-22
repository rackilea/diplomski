public class GameObject {
  boolean isSupported(Command command);
  boolean trigger(Command command);
}

public class Exit extends GameObject {
  ...
}