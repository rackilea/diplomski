#if WOW64 // using x64

[return: MarshalAs(UnmanagedType.Bool)]
[DllImport("WindowsAccessBridge-32.dll", CallingConvention = CallingConvention.Cdecl)]
public extern static bool getAccessibleContextFromHWND(IntPtr hwnd, out Int32 vmID, out Int64 acParent);

#else // using x86

[return: MarshalAs(UnmanagedType.Bool)]
[DllImport("WindowsAccessBridge.dll", EntryPoint = "getAccessibleContextFromHWND", CallingConvention = CallingConvention.Cdecl)]
private extern static bool _getAccessibleContextFromHWND(IntPtr hwnd, out Int32 vmID, out Int32 acParent);

public static bool getAccessibleContextFromHWND(IntPtr hwnd, out Int32 vmID, out Int64 acParent)
{
  Int32 _acParent;

  bool retVal = _getAccessibleContextFromHWND(hwnd, out vmID, out _acParent);
  acParent = _acParent;

  return retVal;
}

#endif