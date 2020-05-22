// in JCustom

static {
    LookAndFeelAddons.contribute(new CustomAddon());
}

// in CustomAddon

@Override
protected void addBasicDefaults(LookAndFeelAddons addon, DefaultsList defaults) {
    super.addBasicDefaults(addon, defaults);
    defaults.add("CustomUI",
            "mypackage.BasicCustomUI");
}

@Override
protected void addMacDefaults(LookAndFeelAddons addon, DefaultsList defaults) {
    super.addMacDefaults(addon, defaults);
    defaults.add("CustomUI",
            "mypackage.MacCustomUI");
}

//... similar methods for all supported LAFs