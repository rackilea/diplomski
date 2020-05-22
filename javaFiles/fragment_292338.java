boolean updating;

@Override public void modelPropertyChange(final PropertyChangeEvent event)
{
    if (updating) {
        // cascading update, ignore
        return;
    }
    updating=true;
    try {
        if(event.getPropertyName().equals("Username")) {
        {
            String username = (String) event.getNewValue();
            this.nameField.setText(username);
        }
        ...
    }
    finally {
        updating=false;
    }
}