keyboardHook = (nCode, wParam, info) -> {
                    if (nCode >= 0) {
                        NativeKeyEvent event = new NativeKeyEvent(info.vkCode, info.time);
                        switch (wParam.intValue()) {
                            case WinUser.WM_KEYDOWN:
                            case WinUser.WM_SYSKEYDOWN:
                                dispatch(EventType.KEY_DOWN, event);
                                break;
                            case WinUser.WM_KEYUP:
                            case WinUser.WM_SYSKEYUP:
                                dispatch(EventType.KEY_UP, event);
                                break;
                        }
                        if (event.consumed()) {
                            return new WinDef.LRESULT(1);
                        }
                    }
                    return new WinDef.LRESULT(0);
                };