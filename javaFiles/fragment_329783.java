Model model = new Model(new Destination(null));

 Destination destination = model.getDestination().getValue(); // destination is not null
 Device device = model.getDestination().getDevice().getValue(); // device will be null, no NPE
 String name = destination.getDevice().getName().getValue(); // name will be null, no NPE

 NavDevice navDevice = model.getDestination().getDevice(); // returns an ever non-null NavDevice, not a Device
 String name = navDevice.getValue().getName(); // cause an NPE by circumventing the navigation structure