public void itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("Selected :" + e.getItem());
    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
        System.out.println("Deselected :" + e.getItem());
    }
}