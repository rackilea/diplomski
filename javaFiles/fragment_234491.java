if (evt.getSource() == btnDeleteField) {
        int lastZIndex = panel.getComponentCount() - 1;
        if (lastZIndex >= 0) {
            panel.remove(lastZIndex);
            if (lastZIndex > 0) {
                panel.remove(lastZIndex - 1);
            }
            panel.revalidate();
        }
    }
    validate();
    panel.repaint();
}