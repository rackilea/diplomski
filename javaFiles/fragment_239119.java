@Override
public Parcelable onSaveInstanceState() {
    final MySavedState ss = new MySavedState(super.onSaveInstanceState());
    ss.myInt = 100;
    return ss;
}

@Override
public void onRestoreInstanceState(Parcelable state) {
    MySavedState ss = (MySavedState) state;

    super.onRestoreInstanceState(ss.getSuperState());

    if(ss.myInt == 100) {
        Log.d("TAG", "Success!");
    }
}

static class MySavedState extends Spinner.BaseSavedState {

    int myInt;

    public MySavedState(Parcelable superState) {
        super(superState);
    }

    public MySavedState(Parcel source) {
        super(source);

        myInt = source.readInt();
    }
}