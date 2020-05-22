byte[] a = new byte[4096];
bis = new MyBAIsWrapper(a);
session.setTermIn(bis);
//here, you could do somethin similar for OoutpuStream if needed, or keep the same initialization...
bos = new ByteArrayOutputStream();
session.setTermOut(bos);
/* Attach the TermSession to the EmulatorView. */
mEmulatorView.attachSession(session);