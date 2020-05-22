public String getLocalBluetoothName(){
    if(mBluetoothAdapter == null){
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }
    String name = mBluetoothAdapter.getName();
    if(name == null){
        System.out.println("Name is null!");
        name = mBluetoothAdapter.getAddress();
    }
    return name;
}