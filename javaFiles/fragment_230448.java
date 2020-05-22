class CustomButton extends JButton {
    CustomButton() {
        // ... normal button init

        // Enable absolute positioning of sub-components.
        setLayout(null);

        updateStyles();

        getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateStyles();
            }
        });
    }

    private void updateStyles() {
        // See below for implementation.
    }

    private int getSynthComponentState() {
        // This is basically a copy of SynthButtonUI.getComponentState(JComponent)
        int state = SynthConstants.ENABLED;
        if (!isEnabled()) {
            state = SynthConstants.DISABLED;
        }

        if (model.isPressed()) {
            if (model.isArmed()) {
                state = SynthConstants.PRESSED;
            } else {
                state = SynthConstants.MOUSE_OVER;
            }
        }
        if (model.isRollover()) {
            state |= SynthConstants.MOUSE_OVER;
        }
        if (model.isSelected()) {
            state |= SynthConstants.SELECTED;
        }
        if (isFocusOwner() && isFocusPainted()) {
            state |= SynthConstants.FOCUSED;
        }
        if (isDefaultButton()) {
            state |= SynthConstants.DEFAULT;
        }
        return state;
    }
}