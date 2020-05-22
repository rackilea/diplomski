private void SendKeysToWindow(string WindowName, string KeysToSend)
    { 
        IntPtr hWnd = FindWindow(null, WindowName);            
        ShowWindow(hWnd, SW_SHOWNORMAL);
        SetForegroundWindow(hWnd);
        Thread.Sleep(50);
        SendKeys.SendWait(KeysToSend);           
    }