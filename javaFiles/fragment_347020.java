Memory data = ...;
// mzH = *(MZHeader*) dPtr;
MZHeader mzH = new MZHeader(data);
mzH.read(); // or put this in the MZHeader(Pointer) ctor
// peH = *(PE_Header*)&dPtr[mzH.offsetToPE];
PE_Header peH = new PE_Header(data.share(mzH.offsetToPE));
peH.read(); // or put this in the PE_Header(Pointer) ctor
// peXH = *(PE_ExtHeader*)&dPtr[mzH.offsetToPE + sizeof(PE_Header)];
PE_ExtHeader peXH = new PE_ExtHeader(data.share(mzH.offsetToPE + peH.size()));
peXH.read(); // or put this in the PE_ExtHeader(Pointer) actor