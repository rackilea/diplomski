Class[] parameterTypes = new Class[1];
parameterTypes[0] = AirlineAgency.class;

Constructor constructor = cabAgencyClass.getConstructor(parameterTypes);

Object[] arguments = new Object[1];
arguments[0] = airlineAgency;

cabAgency = (CabAgency)constructor.newInstance(arguments);