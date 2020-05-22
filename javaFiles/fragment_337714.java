DatabaseHandler db = new DatabaseHandler(this);

    // Reading all device
    List<Device> devices = db.getAllContacts();       

    for (Device dev : devices) {

          if(dev.getNameDevice() == DeviceToUpadeName){
            //do the get of all information
            device_number = dev.getDeviceNumber();//This getmethod is from you Device Class
            device_password = dev.getDevicePassword();
          }
}