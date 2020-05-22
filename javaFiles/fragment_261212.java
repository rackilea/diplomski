static long handleAppleEvent (long id, long sel, long event_id, long reply_id) {
    // This is a handler for AppleEvents that are registered with [NSAppleEventManager setEventHandler:...]
    // It matches this selector (footprint):
    //   - (void)handleAppleEvent:(NSAppleEventDescriptor *)event withReplyEvent:(NSAppleEventDescriptor *)reply

    // Invoke [[event paramDescriptorForKeyword:keyDirectObject] stringValue] to get the direct object containing the URL
    long direct_desc_id = OS.objc_msgSend (event_id, sel_paramDescriptorForKeyword, keyDirectObject);
    long direct_str_id = OS.objc_msgSend (direct_desc_id, sel_stringValue);
    NSString nsStr = new NSString (direct_str_id);
    String str = nsStr.getString();
    // now 'str' contains the URL

    System.out.println ("handleAppleEvent invoked -- argument: "+url);
    return 0;
}