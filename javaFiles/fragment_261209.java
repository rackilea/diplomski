// id mgr = [NSAppleEventManager sharedAppleEventManager]
SEL sel_ sharedAppleEventManager = sel_registerName("sharedAppleEventManager");
id mgr = objc_msgSend (objc_getClass("NSAppleEventManager"), sharedAppleEventManager);

// and the rest
SEL sel_setEventHandler = sel_registerName("setEventHandler:andSelector:forEventClass:andEventID:");
SEL sel_handleAppleEvent = sel_registerName("handleAppleEvent:withReplyEvent:");
objc_msgSend (mgr, sel_setEventHandler, targetObject, sel_handleAppleEvent, kInternetEventClass, kAEGetURL);