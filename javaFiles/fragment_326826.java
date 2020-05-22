public void addElements(final List<String> data) {
    if (SwingUtilities.isEventDispatchThread())
        return;
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            for (String item : data) {
                usersData.addElement(item);
                System.out.println(item);
            }
        }
    });
}