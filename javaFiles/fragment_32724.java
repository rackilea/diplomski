Bundle bundle = Platform.getBundle("org.eclipse.platform");

Version version = bundle.getVersion();

if (version.getMajor() == 4 && version.getMinor() == 4)
 {
   ... version 4.4
 }