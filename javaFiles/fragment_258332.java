rc=CoInitialize(NULL);
rc=OleInitialize(NULL);
{
     WNDCLASSEX     wc; 
     // Register the class of our window to host the browser. 'WindowProc' is our message handler
 // and 'ClassName' is the class name. You can choose any class name you want.
 ZeroMemory(&wc, sizeof(WNDCLASSEX));
 wc.cbSize = sizeof(WNDCLASSEX);
 wc.hInstance = hinstance;
 wc.lpfnWndProc = WindowProc;
 wc.lpszClassName = &ClassName[0];
 rc=RegisterClassEx(&wc);
}