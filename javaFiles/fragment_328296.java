// Create a Mockito mock, which is an automatic subclass with
// all of its methods overridden to track and verify every method call.
BleService mockBleService = Mockito.mock(BleService.class);

// Importantly, you need to make sure that your system under test calls this
// new object instead of the default (real) dependency.
Command commandUnderTest = new Command(mockBleService);

// Now you interact with your Command exactly like you'd expect consumers to.
commandUnderTest.sendCommand(0);

// Using the static method Mockito.verify, you can confirm the call came through.
verify(mockBleService).writeToDevice("PowerOnCmd");