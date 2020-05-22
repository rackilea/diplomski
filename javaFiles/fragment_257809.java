#if defined(OS_WIN)
  if (enable == JNI_FALSE) {
    HWND browserHandle = browser->GetHost()->GetWindowHandle();
    if (CefCurrentlyOn(TID_UI))
      FocusParent(browserHandle);
    else
      CefPostTask(TID_UI, base::Bind(&FocusParent, browserHandle));
  }
#endif