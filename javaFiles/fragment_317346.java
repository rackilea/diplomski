stikersField.setChangeListener(new FieldChangeListener() {

    public void fieldChanged(Field field, int context) {
        if (!option_sticker) {
            try {
                scrollToBottom();
                ef.setFocus();
                emojiiVerticalScroll.add(stickerhorizontalScroll);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            option_sticker = true;
            setStatus(emojiiVerticalScroll);
        } else {
            option_sticker = false;
            emojiiVerticalScroll.delete(stickerhorizontalScroll);
            // setStatus(stickerVerticalScroll);
            setStatus(emojiiVerticalScroll);
        }
    }
});