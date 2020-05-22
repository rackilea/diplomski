public interface InetAddr extends StdCallLibrary {
    InetAddr INSTANCE = (InetAddr) 
            Native.loadLibrary("wsock32.dll", InetAddr.class);

    ULONG inet_addr(String cp);                     //in_addr creator. Creates the in_addr C struct used below
}

public interface IcmpEcho extends StdCallLibrary {
    IcmpEcho INSTANCE = (IcmpEcho)
            Native.loadLibrary("iphlpapi.dll", IcmpEcho.class);

    int IcmpSendEcho(
            HANDLE IcmpHandle,                      //Handle to the ICMP
            ULONG DestinationAddress,               //Destination address, in the form of an in_addr C Struct defaulted to ULONG
            Pointer RequestData,                    //Pointer to the buffer where my Message to be sent is
            short RequestSize,                      //size of the above buffer. sizeof(Message)
            byte[] RequestOptions,                  //OPTIONAL!! Can set this to NULL
            Pointer ReplyBuffer,                    //Pointer to the buffer where the replied echo is written to
            int ReplySize,                          //size of the above buffer. Normally its set to the sizeof(ICMP_ECHO_REPLY), but arbitrarily set it to 256 bytes
            int Timeout);                           //time, as int, for timeout

    HANDLE IcmpCreateFile();                        //win32 ICMP Handle creator

    boolean IcmpCloseHandle(HANDLE IcmpHandle);     //win32 ICMP Handle destroyer
}