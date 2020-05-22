static final long class_NSAppleEventManager = OS.objc_getClass("NSAppleEventManager");
static final long sel_sharedAppleEventManager = OS.sel_registerName("sharedAppleEventManager");
static final long sel_setEventHandler = OS.sel_registerName("setEventHandler:andSelector:forEventClass:andEventID:");
static final long sel_handleAppleEvent = OS.sel_registerName("handleAppleEvent:withReplyEvent:");
static final long sel_paramDescriptorForKeyword = OS.sel_registerName("paramDescriptorForKeyword:");
static final long sel_stringValue = OS.sel_registerName("stringValue");

static final long kInternetEventClass = 0x4755524C; // 'GURL'
static final long kAEGetURL = 0x4755524C; // 'GURL'
static final long kCoreEventClass = 0x61657674; // 'aevt'
static final long kAEOpenApplication = 0x6F617070; // 'oapp'
static final long kAEReopenApplication = 0x72617070; // 'rapp'
static final long keyDirectObject = 0x2d2d2d2d; // '----'