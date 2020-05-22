@Override
public View onCreateInputView() {
    int schema = loadColor();

    //Default code

    //mInputView = (LatinKeyboardView) getLayoutInflater().inflate(
    //      R.layout.input, null);

    mInputView = (LatinKeyboardView) getLayoutInflater().inflate(
            schema, null);

    mInputView.setOnKeyboardActionListener(this);
    mInputView.setKeyboard(mQwertyKeyboard);
    return mInputView;
}

public static int loadColor() {

    String dbg = android.os.Debug.isDebuggerConnected() ? "Y" : "N";

    android.util.Log.d("loadColor", "Debugger attached: " +  dbg);

    //android.os.Debug.waitForDebugger(); //Comment this out before releasing the keyboard

    int temp = 1;
    int id = 0;

    if (temp == 1)
    {
        id = R.layout.input_day;
    }
    else
    {
        id =  R.layout.input;
    }

    android.util.Log.d("loadColor", Integer.toString(id));
    return id;
}