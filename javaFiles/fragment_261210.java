// create an NSObject subclass for our target object
char objcClassName[] = "ObjCAppleEventHandler";
id objcClass = objc_allocateClassPair (objc_getClass("NSObject"), objcClassName);

// add the callback method to the class
SEL sel_handleAppleEvent = sel_registerName("handleAppleEvent:withReplyEvent:");
class_addMethod (objcClass, sel_handleAppleEvent, handleAppleEvent, "i@:@@");

// register the class
objc_registerClassPair (objcClass)

// create an object instance
id targetObject = class_createInstance (objcClass, 0);

// ... here follows the above code with the setEventHandler invocation
// (note: `SEL sel_handleAppleEvent` appears twice - the 2nd one can be removed)