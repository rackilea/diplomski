public void changeSomethingInGuiAsync() {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            Gui.this.changeSomethingInGui();
        }
    });
}