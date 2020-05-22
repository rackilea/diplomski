AWUSB_STATUS AwUsbGetConnectionStatus (
   IN   LPCWSTR Hub,
   OUT  PDWORD  IpAddress,
   OUT  PAWUSB_STATUS   Status,
   IN   DWORD   Timeout,
   IN   HANDLE  hEvent OPTIONAL
);

// Java mapping
int AwUsbGetConnectionStatus(String Hub, DWORDByReference IpAddress, IntByReference Status, DWORD Timeout, HANDLE hEvent);