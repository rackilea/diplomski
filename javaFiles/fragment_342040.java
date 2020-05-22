@BusSignalHandler(iface = "org.sample.MyInterface", signal = "MySignal")
 public void handleSignal(String str)
 {
 }

 @BusSignalHandler(iface = "org.myapp.IMyInterface", signal = "EmitMySignal")
 public void handleSignal(String str)
 {
 }