public Pilot(String name, String license){
        setName(name);
        setLicense(license);
    }
    public void setLicense(String license) {
        this.license = (license == null) ? "" : license;
    }
    public void setName(String name) {
        this.name = (name == null) ? "" : name;
    }