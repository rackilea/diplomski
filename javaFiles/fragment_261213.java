// Get access to a callback function for receiving the sel_handleAppleEvent message
aeCallback = new Callback(Main.class, "handleAppleEvent", 4);
long aeProc = aeCallback.getAddress();

// Create a ObjC class that provides a method with the sel_handleAppleEvent footprint
String objcClassName = "ObjCAppleEventHandler";
long objcClass = OS.objc_allocateClassPair(OS.class_NSObject, objcClassName, 0);
OS.class_addMethod(objcClass, sel_handleAppleEvent, aeProc, "i@:@@");
OS.objc_registerClassPair(objcClass);
long objcHandlerInstance = OS.class_createInstance (objcClass, 0);

// Invoke [[NSAppleEventManager sharedAppleEventManager] setEventHandler:objcHandlerInstance andSelector:sel_handleAppleEvent forEventClass:kInternetEventClass andEventID:kAEGetURL]
long sharedAppleEventMgr = OS.objc_msgSend (class_NSAppleEventManager, sel_sharedAppleEventManager);
OS.objc_msgSend (sharedAppleEventMgr, sel_setEventHandler, objcHandlerInstance, sel_handleAppleEvent, kInternetEventClass, kAEGetURL);