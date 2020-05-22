@Override
public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    for (Component component : getComponents())
        component.setEnabled(enabled);
    }
}