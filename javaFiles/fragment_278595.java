import com.sun.jna.platform.win32.Advapi32; 
import com.sun.jna.platform.win32.Kernel32; 
import com.sun.jna.platform.win32.WinBase; 
import com.sun.jna.platform.win32.WinNT.HANDLEByReference; 

HANDLEByReference phUser = new HANDLEByReference() 
if(! Advapi32.INSTANCE.LogonUser("administrator", InetAddress.getLocalHost().getHostName(),
    "password", WinBase.LOGON32_LOGON_NETWORK, WinBase.LOGON32_PROVIDER_DEFAULT, phUser)) 
{
  throw new LastErrorException(Kernel32.INSTANCE.GetLastError()); 
}