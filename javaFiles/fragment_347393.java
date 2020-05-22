PipedOutputStream pipeOut = new PipedOutputStream ();
PipedInputStream pipeIn = new PipedInputStream (pipeOut);
DataOutputStream os = new DataOutputStream (pipeOut);

long uInt = 0xff1ffffdL;

System.out.println ("" + uInt + " vs " + ((int) uInt));
os.writeInt ((int) uInt);
for (int i = 0; i < 4; i++) System.out.println (pipeIn.read ());

uInt = 0x000ffffdL;
System.out.println ("" + uInt + " vs " + ((int) uInt));
os.writeInt ((int) uInt);
for (int i = 0; i < 4; i++) System.out.println (pipeIn.read ());