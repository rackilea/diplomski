%module MyNativeClass
%include <enums.swg>
%javaconst(1);

%rename("$ignore") ""; // ignore all
%rename("%s") "MYSTATUS"; // except MYSTATUS

%include "BigHeaderFile.h"