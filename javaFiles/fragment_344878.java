@Override
public void actionPerformed(ActionEvent e) {
    boolean didChange = false;
    if (pressed) {
        if (!inputs.contains(name)) {
            if (inputs.size() >= 3) {
                inputs.clear();
            }
            inputs.add(name);
            didChange = true;
        }
    } else {
        didChange = inputs.remove(name);
    }

    if (didChange) {
        inputDidChange();
    }
}