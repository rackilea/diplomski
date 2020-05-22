@Override
public void onAttach(Activity activity) {
    super.onAttach(context);

    try {
        onColorChangeListener = (OnColorChangeListener) context;
    }
    catch catch (Exception e){
        // you should really do something here with this exception
    }
}