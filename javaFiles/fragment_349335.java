private static void printSelection(ListSelectionModel model) {
    System.out.print("[");
    for (int i = model.getMinSelectionIndex(); i <= model.getMaxSelectionIndex(); i++) {
        if(i > model.getMinSelectionIndex()) {
            System.out.print(",");
        }
        if(model.isSelectedIndex(i)) {
            System.out.print(i);
            if(i == model.getAnchorSelectionIndex()) {
                System.out.print("A");
            }
            if(i == model.getLeadSelectionIndex()) {
                System.out.print("L");
            }
        }
    }
    System.out.println("]");
}