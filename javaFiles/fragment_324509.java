Device device = new Device();
device.setName("Device Name 01");
device.setUuid("uuid value");
device.SetRssi("rssi value");

ArrayList<Device> deviceList = new ArrayList<>();
deviceList.add(device);

//Init adapter and fill it
DeviceRecyclerView deviceRecyclerView = new DeviceRecyclerView(deviceList);


LinearLayoutManager llm = new LinearLayoutManager(getContext());
recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(llm);
recyclerView.setItemAnimator(new DefaultItemAnimator());
recyclerView.setAdapter(deviceRecyclerView);