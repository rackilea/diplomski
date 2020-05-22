sbarMi.addItemListener((ItemEvent e) -> {
    if (e.getStateChange() == ItemEvent.SELECTED) {
        statusbar.setVisible(true);
        // Using System.out
        System.out.println("On Progress...");
        // Or using a logger (defined somewhere else, using Logger.getLogger or a logging framework.)
        logger.info("On Progress.");
    } else {
        statusbar.setVisible(false);
    }
});