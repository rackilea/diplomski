public void menuSelected(MenuEvent me) {
    if(me.getSource() == em) {
        boolean canPasteResult = false;
        try {
            canPasteResult = canPaste();
        } catch(Exception e) { System.out.println(e); }
        paste.setEnabled(canPasteResult);
    }
}