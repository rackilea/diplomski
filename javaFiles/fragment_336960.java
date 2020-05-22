// Works
setValue("something", "something");
setValue(new Object(), new String());

// Doesn't work
setValue(new String(), new Object());