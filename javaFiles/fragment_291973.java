private class DDTTableView {

    private ObjectProperty<DDT> ddt;
    private ObjectProperty<Contact> contact;
    private StringProperty rif;

    public DDTTableView() {
        this.ddt = new SimpleObjectProperty<>();
        this.contact = new SimpleObjectProperty<>();
        this.rif = new SimpleStringProperty("");

        this.setContact(dataManager.getContactForCodeType(o.getAnaTipe(), o.getAnaCode().trim()));

        ListChangeListener<DDTItem> rowsListener = (ListChangeListener.Change<? extends DDTItem> change) -> {
            rif.set(/* buildString */);
        };

        this.ddt.addListener((obs, oldDdt, newDdt) -> {
            if (oldDdt != null) {
                oldDdt.getRows().removeListener(rowsListener);
            }
            if (newDdt != null) {
                newDdt.getRows().addListener(rowsListener);
            }
        });


    }

    public DDTTableView(DDT o) {
        this();

        this.setDdt(o);

    }

    public StringProperty rifProperty() {
        return this.rif;
    }

    public String getRif() {
        return this.rif.get();
    }

    public void setRif(String r) {
        this.rif.set(r);
    }

    public ObjectProperty<DDT> ddtProperty() {
        return ddt;
    }

    public DDT getDdt() {
        return ddt.get();
    }

    public void setDdt(DDT ddt) {
        this.ddt.set(ddt);
    }

    public ObjectProperty<Contact> contactProperty() {
        return contact;
    }

    public Contact getContact() {
        return contact.get();
    }

    public void setContact(Contact contact) {
        this.contact.set(contact);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.ddt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DDTTableView other = (DDTTableView) obj;
        if (!Objects.equals(this.ddt, other.ddt)) {
            return false;
        }
        return true;
    }
}