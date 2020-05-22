public interface OnChange() {
  void changed();
}

public class ListenerHolder {
    public static OnChange onChange = new OnChange( ... );
}

MyClass mClass = new MyClass();

@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    ListenerHolder.onChange.changed();
}