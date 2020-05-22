public static String getLocalBluetoothName(){
    String name = null;

    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
    if (adapter == null) {
        //System.out.println("Can't get adapter");
        Log.d(TAG, "Can't get adapter");
        return name;
    }

    if ((name = adapter.getName()) == null) {
        //System.out.println("Name is null!");
        Log.d(TAG, "Name is null!");
        name = adapter.getAddress();
    }

    return name;
}