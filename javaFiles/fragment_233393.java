boolean alreadyExist = false;
    for(cBT_DeviceList mBTDeviceObj : mBTDevice){
        if(mDevice.getName().equals(mBTDeviceObj.getName())){
            alreadyExist = true;
        }
    }
    if (!alreadyExist) {
        cBT_popup.mBTDevice.add(mDevice);
        cBT_popup.cBTDeviceListAdapter.notifyDataSetChanged();
    }