private boolean compositionReplaced(InputConnection ic) {

    boolean isReplaced = true;

    switch (composing.toLowerCase()) {

        case "e19":
            ic.commitText("M", 1);
            composing = "";
            break;

            // Can be composed more
        case "e1":
            ic.setComposingText("E", 1);
            stillComposible = "E";
            break;

        case "e9":
            ic.commitText("E", 1);
            composing = "";
            break;

        // No replacement occur
        default:
            isReplaced = false;
            break;
    }
    return isReplaced;
}