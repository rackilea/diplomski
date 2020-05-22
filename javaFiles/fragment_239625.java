// initialize the DEVMODE structure
DEVMODE dm = new DEVMODE();
dm.dmDeviceName = new string(new char[32]);
dm.dmFormName = new string(new char[32]);
dm.dmSize = Marshal.SizeOf(dm);

if (0 != NativeMethods.EnumDisplaySettings(null,
         NativeMethods.ENUM_CURRENT_SETTINGS, ref dm))
{
   // swap width and height
   int temp = dm.dmPelsHeight;
   dm.dmPelsHeight = dm.dmPelsWidth;
   dm.dmPelsWidth = temp;

   // determine new orientation
   switch(dm.dmDisplayOrientation)
   {
      case NativeMethods.DMDO_DEFAULT:
         dm.dmDisplayOrientation = NativeMethods.DMDO_270;
         break;
      case NativeMethods.DMDO_270:
         dm.dmDisplayOrientation = NativeMethods.DMDO_180;
         break;
      case NativeMethods.DMDO_180:
         dm.dmDisplayOrientation = NativeMethods.DMDO_90;
         break;
      case NativeMethods.DMDO_90:
         dm.dmDisplayOrientation = NativeMethods.DMDO_DEFAULT;
         break;
      default:
         // unknown orientation value
         // add exception handling here
         break;
   }

   int iRet = NativeMethods.ChangeDisplaySettings(ref dm, 0);
   if (NativeMethods.DISP_CHANGE_SUCCESSFUL != iRet)
   {
      // add exception handling here
   }
}