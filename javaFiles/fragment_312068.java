@Override
public void onKey(int i, int[] ints) {

    InputConnection ic = getCurrentInputConnection();
    char code = (char) i;
    playClick(i);

    switch (i) {

        // Added special case for deleting composed text
        case Keyboard.KEYCODE_DELETE:
            if (composing.length() == 0) {
                ic.deleteSurroundingText(1, 0);
            } else {
                composing = "";
                ic.commitText("", 0);
            }

            break;

        case Keyboard.KEYCODE_SHIFT:
            isCaps = !isCaps;
            keyboard.setShifted(isCaps);
            kv.invalidateAllKeys();
            break;

        case Keyboard.KEYCODE_DONE:
            ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
            break;

        default:
            if (Character.isLetter(code) && isCaps)
                code = Character.toUpperCase(code);

            // If code point is "e" or "E" start a new composition
            if (String.valueOf(code).toLowerCase().equals("e")) {
                if (composing.length() > 0) {   // Pass through previous text if needed
                    ic.commitText(composing, composing.length());
                }
                composing = String.valueOf(code);
                ic.setComposingText(composing, composing.length());

                // Continue composing longer text if
            } else if (composing.length() > 0) {
                composing += code;


                // Check for replacement of composition
                if (!compositionReplaced(ic)) {

                    // Replacement followed by no replacement - special case
                    if (stillComposible.length() > 0) {
                        String text = stillComposible + code;
                        ic.commitText(text, text.length());

                        // No replacement case
                    } else {
                        ic.setComposingText(composing, composing.length());
                    }
                }

                // Otherwise pass the code point through
            } else {
                composing = "";
                ic.commitText(String.valueOf(code), 1);
            }

            // No pattern matches are larger than 3 characters.
            // If nothing matched, pass the code points through.
            if (composing.length() >= 3) {
                ic.finishComposingText();
                composing = "";
            }
    }
 }