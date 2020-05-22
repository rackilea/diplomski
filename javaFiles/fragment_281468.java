if (selectedColumn == column){
    bg = new Color(107, 142, 35);
    setFont(getFont().deriveFont(Font.BOLD));// !!!!trying to do it here!!!!
} else {
    setFont(UIManager.getFont("TableHeader.font"));
}