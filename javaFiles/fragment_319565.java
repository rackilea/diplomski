GetDataInterface sGetDataInterface;


public interface GetDataInterface {
    ArrayList<String> getDataList();
}

@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
        sGetDataInterface= (GetDataInterface) activity;
    } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString() + "must implement GetDataInterface Interface");
    }

    @Override
public void onResume() {
    super.onResume();
    if(sGetDataInterface != null){
            mData = sGetDataInterface.getDataList();
    }
}
}