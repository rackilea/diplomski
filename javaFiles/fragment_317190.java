Window window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();

if (window != null)
{
    WindowEvent windowClosing = new WindowEvent(window, WindowEvent.WINDOW_CLOSING);
    window.dispatchEvent(windowClosing);
}