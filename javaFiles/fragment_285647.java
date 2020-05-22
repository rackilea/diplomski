Control control = .. create control ...

GridData data = new GridData(flags);
data.exclude = true;
control.setLayoutData(data);

control.setVisible(false);