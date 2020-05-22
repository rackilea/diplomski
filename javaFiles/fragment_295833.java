public static void pressUnicode(Robot r, int key_code)
{
    r.keyPress(KeyEvent.VK_ALT);

    for(int i = 3; i >= 0; --i)
    {
        // extracts a single decade of the key-code and adds
        // an offset to get the required VK_NUMPAD key-code
        int numpad_kc = key_code / (int) (Math.pow(10, i)) % 10 + KeyEvent.VK_NUMPAD0;

        r.keyPress(numpad_kc);
        r.keyRelease(numpad_kc);
    }

    r.keyRelease(KeyEvent.VK_ALT);
}