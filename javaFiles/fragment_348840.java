private PlatformAdapter adapter;

public MyGame (PlatformAdapter adapter){
    this.adapter = adapter;
}

void showToast(String message){
    if (adapter != null) adapter.showToast(message);
}