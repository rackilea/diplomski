import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.ptr.IntByReference;

public interface CLibrary extends Library {
public CLibrary INSTANCE = (CLibrary) Native.loadLibrary(Platform.isWindows()?"msvcrt":"c",CLibrary.class);

int kill(long pid, int sig);
int reboot(int magic, int magic2, int cmd, IntByReference arg);
int reboot(int cmd);

int LINUX_REBOOT_MAGIC1 = 0xfee1dead;
int LINUX_REBOOT_MAGIC2 = 672274793;
int LINUX_REBOOT_MAGIC2A = 85072278;
int LINUX_REBOOT_MAGIC2B = 369367448;
int LINUX_REBOOT_MAGIC2C = 537993216;

int LINUX_REBOOT_CMD_RESTART = 0x01234567;
int LINUX_REBOOT_CMD_HALT = 0xCDEF0123;
int LINUX_REBOOT_CMD_CAD_ON =0x89ABCDEF;
int LINUX_REBOOT_CMD_CAD_OFF = 0x00000000;
int LINUX_REBOOT_CMD_POWER_OFF = 0x4321FEDC;
int LINUX_REBOOT_CMD_RESTART2 = 0xA1B2C3D4;
int LINUX_REBOOT_CMD_SW_SUSPEND = 0xD000FCE2;
int LINUX_REBOOT_CMD_KEXEC = 0x45584543;

}

p s v main(){
   CLibrary.INSTANCE.reboot(Clibrary.LINUX_REBOOT_CMD_POWER_OFF);
}