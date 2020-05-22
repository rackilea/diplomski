public abstract class BleServiceFragment  extends Fragment{

private static final int REQUEST_ENABLE_BT = 0;
private BluetoothLeService mService=null;

protected abstract BroadcastReceiver getBleReceiver();
private IntentFilter filter =makeFilter();
boolean receiverRegistered=false;

protected IntentFilter makeFilter(){
    IntentFilter filter = new IntentFilter(Const.Intent.BLE_CARD_LIST);
    return filter;
}

@Override
public void onStart() {
    super.onStart();

    final BluetoothManager bluetoothManager =
            (BluetoothManager) getActivity().getSystemService(Context.BLUETOOTH_SERVICE);
    mBluetoothAdapter = bluetoothManager.getAdapter();

    // Checks if Bluetooth is supported on the device.
    if (mBluetoothAdapter == null) {
        Toast.makeText(getActivity(), getResources().getString(R.string.error_bluetooth_not_supported), Toast.LENGTH_SHORT).show();
        getActivity().finish();
        return;
    }
}

@Override
public void onResume() {
    super.onResume();
    if(!mBluetoothAdapter.isEnabled())
    {

            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);

    }

    getActivity().registerReceiver(getBleReceiver(), filter);
    receiverRegistered=true;
}

@Override
public void onPause()
{
    super.onPause();
    if(receiverRegistered)
    {
        getActivity().unregisterReceiver(getBleReceiver());
        receiverRegistered=false;
    }
}

@Override
public void onStop() {
    super.onStop();
    if(receiverRegistered)
    {
        getActivity().unregisterReceiver(getBleReceiver());
        receiverRegistered=false;
    }
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    // User chose not to enable Bluetooth.
    if (requestCode == REQUEST_ENABLE_BT && resultCode == Activity.RESULT_CANCELED) {
        getActivity().finish();
        return;
    }
    super.onActivityResult(requestCode, resultCode, data);
}