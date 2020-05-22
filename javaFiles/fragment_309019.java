class Child extends JDialog {
        public Child(Parent parent) {
            super((JFrame)null);
            setType(JFrame.Type.UTILITY);
            setVisible(true);
            setSize(100, 100);
        }
}