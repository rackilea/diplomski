// jdk/src/solaris/native/java/lang/java_props_macosx.c
int isInAquaSession() {
  // environment variable to bypass the aqua session check
  char *ev = getenv("AWT_FORCE_HEADFUL");
  if (ev && (strncasecmp(ev, "true", 4) == 0)) {
    // if "true" then tell the caller we're in an Aqua session without actually checking
    return 1;
  }
  // Is the WindowServer available?
  SecuritySessionId session_id;
  SessionAttributeBits session_info;
  OSStatus status = SessionGetInfo(callerSecuritySession, &session_id, &session_info);
  if (status == noErr) {
    if (session_info & sessionHasGraphicAccess) {
        return 1;
    }
  }
  return 0; 
}