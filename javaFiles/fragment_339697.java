@Override
public void onAttach(Activity activity)
{
    super.onAttach(activity);

    try
    {
        mDeviceListener = (OnDeviceSelectedListener)activity;
    }
    catch (ClassCastException e)
    {
        throw new ClassCastException(activity.toString() + "must implement OnDeviceSelectedListner");
    }
}