import java.nio.ByteBuffer;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinBase.PROCESS_INFORMATION;
import com.sun.jna.platform.win32.WinBase.SECURITY_ATTRIBUTES;
import com.sun.jna.platform.win32.WinBase.STARTUPINFO;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinNT.HANDLEByReference;
import com.sun.jna.ptr.IntByReference;


public class RunTest {

    static HANDLEByReference childStdInRead = new HANDLEByReference();
    static HANDLEByReference childStdInWrite = new HANDLEByReference();
    static HANDLEByReference childStdOutRead = new HANDLEByReference();
    static HANDLEByReference childStdOutWrite = new HANDLEByReference();

    static final int HANDLE_FLAG_INHERIT = 0x00000001;
    static final int HANDLE_FLAG_PROTECT_FROM_CLOSE = 0x00000002;


    static final int BUFSIZE = 4096;
    static final int GENERIC_READ = 0x80000000;
    static final int FILE_ATTRIBUTE_READONLY = 1;
    private static final int OPEN_EXISTING = 3;
    private static final DWORD STD_OUTPUT_HANDLE = new DWORD(-11);
    private static final int STARTF_USESTDHANDLES = 0x00000100;

    static HANDLE inputFile = null;

    static void createChildProcess(String cmd){
        String szCmdline = cmd;

        PROCESS_INFORMATION processInformation = new PROCESS_INFORMATION();
        STARTUPINFO startupInfo = new STARTUPINFO();
        startupInfo.cb = new DWORD(processInformation.size());
        startupInfo.hStdError = childStdOutWrite.getValue();
        startupInfo.hStdOutput = childStdOutWrite.getValue();
        startupInfo.hStdInput = childStdInRead.getValue();
        startupInfo.dwFlags |= STARTF_USESTDHANDLES;

        // Create the child process. 
        if (!Kernel32.INSTANCE.CreateProcess(
                null, 
                szCmdline, 
                null, 
                null, 
                true, 
                new DWORD(0x00000020), 
                null, 
                null, 
                startupInfo, 
                processInformation)){
            System.err.println(Kernel32.INSTANCE.GetLastError());
        }
        else {
            com.sun.jna.platform.win32.Kernel32.INSTANCE.WaitForSingleObject(processInformation.hProcess, 0xFFFFFFFF);

            com.sun.jna.platform.win32.Kernel32.INSTANCE.CloseHandle(processInformation.hProcess);
            com.sun.jna.platform.win32.Kernel32.INSTANCE.CloseHandle(processInformation.hThread);
        }
    }

    static void WriteToPipe() 

    // Read from a file and write its contents to the pipe for the child's STDIN.
    // Stop when there is no more data. 
    { 
        IntByReference dwRead = new IntByReference();
        IntByReference dwWritten = new IntByReference(); 
        ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);
        Pointer data = Native.getDirectBufferPointer(buf);
        boolean bSuccess = true;

        for (;;) 
        { 
            bSuccess = com.sun.jna.platform.win32.Kernel32.INSTANCE.ReadFile(inputFile, buf, BUFSIZE, dwRead, null);
            if ( ! bSuccess || dwRead.getValue() == 0 ) break; 

            bSuccess = com.sun.jna.platform.win32.Kernel32.INSTANCE.WriteFile(childStdInWrite.getValue(), data.getByteArray(0, BUFSIZE), dwRead.getValue(), dwWritten, null);
            if ( ! bSuccess ) break; 
        } 

        // Close the pipe handle so the child process stops reading. 

        if (!com.sun.jna.platform.win32.Kernel32.INSTANCE.CloseHandle(childStdInWrite.getValue())){ 
            System.err.println(Kernel32.INSTANCE.GetLastError()); 
        }
    }

    static void ReadFromPipe() 

    // Read output from the child process's pipe for STDOUT
    // and write to the parent process's pipe for STDOUT. 
    // Stop when there is no more data. 
    { 
        IntByReference dwRead = new IntByReference();
        IntByReference dwWritten = new IntByReference(); 
        ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);
        Pointer data = Native.getDirectBufferPointer(buf);
        boolean bSuccess = true;
        HANDLE hParentStdOut = Kernel32.INSTANCE.GetStdHandle(STD_OUTPUT_HANDLE);

        // Close the write end of the pipe before reading from the 
        // read end of the pipe, to control child process execution.
        // The pipe is assumed to have enough buffer space to hold the
        // data the child process has already written to it.

        if (!com.sun.jna.platform.win32.Kernel32.INSTANCE.CloseHandle(childStdOutWrite.getValue())){ 
            System.err.println(Kernel32.INSTANCE.GetLastError()); 
        }

        for (;;) 
        { 
            bSuccess = com.sun.jna.platform.win32.Kernel32.INSTANCE.ReadFile( childStdOutRead.getValue(), buf, BUFSIZE, dwRead, null);
            if( ! bSuccess || dwRead.getValue() == 0 ) break; 

            bSuccess = com.sun.jna.platform.win32.Kernel32.INSTANCE.WriteFile(hParentStdOut, data.getByteArray(0, BUFSIZE), dwRead.getValue(), dwWritten, null);
            if (! bSuccess ) break; 
        } 
    }   
    /**
     * {@link http://msdn.microsoft.com/en-us/library/windows/desktop/ms682499(v=vs.85).aspx}
     */
    public static void main(String[] args) {

        if (args.length < 1) {
              System.err.println("Please specify a command.\n");
              System.exit(1);
        }

        if (args.length < 2) {
              System.err.println("Please specify an input file.\n");
              System.exit(1);
        }

        SECURITY_ATTRIBUTES saAttr = new SECURITY_ATTRIBUTES();
        saAttr.dwLength = new DWORD(saAttr.size());
        saAttr.bInheritHandle = true;
        saAttr.lpSecurityDescriptor = null;

        // Create a pipe for the child process's STDOUT. 
        if (!com.sun.jna.platform.win32.Kernel32.INSTANCE.CreatePipe(childStdOutRead, childStdOutWrite, saAttr, 0)){
            System.err.println(Kernel32.INSTANCE.GetLastError());
        }

        // Ensure the read handle to the pipe for STDOUT is not inherited.
        if (!com.sun.jna.platform.win32.Kernel32.INSTANCE.SetHandleInformation(childStdOutRead.getValue(), HANDLE_FLAG_INHERIT, 0)){
            System.err.println(Kernel32.INSTANCE.GetLastError());;
        }

        // Create a pipe for the child process's STDIN. 
        if (!com.sun.jna.platform.win32.Kernel32.INSTANCE.CreatePipe(childStdInRead, childStdInWrite, saAttr, 0)){
            System.err.println(Kernel32.INSTANCE.GetLastError());
        }

        // Ensure the write handle to the pipe for STDIN is not inherited.
        if (!com.sun.jna.platform.win32.Kernel32.INSTANCE.SetHandleInformation(childStdInWrite.getValue(), HANDLE_FLAG_INHERIT, 0)){
            System.err.println(Kernel32.INSTANCE.GetLastError());;
        }

        createChildProcess(args[0]);

        inputFile = com.sun.jna.platform.win32.Kernel32.INSTANCE.CreateFile(
                args[1], 
                GENERIC_READ, 
                0, 
                null, 
                OPEN_EXISTING, 
                FILE_ATTRIBUTE_READONLY, 
                null);

        // Write to the pipe that is the standard input for a child process. 
        // Data is written to the pipe's buffers, so it is not necessary to wait
        // until the child process is running before writing data.

           WriteToPipe(); 
           System.out.println( "\n->Contents of \""+args[1]+"\" written to child STDIN pipe.\n");

        // Read from pipe that is the standard output for child process. 

           System.out.println( "\n->Contents of child process STDOUT:\n\n" + args[1]);
           ReadFromPipe(); 

           System.out.println("\n->End of parent execution.\n");

        // The remaining open handles are cleaned up when this process terminates. 
        // To avoid resource leaks in a larger application, close handles explicitly. 


    }

}