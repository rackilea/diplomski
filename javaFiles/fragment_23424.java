...
public Company getCompany() {
    try {
        return new Company((Map) get("company"));
    } catch(NullPointerException e) {
        return null;
    }
}

public void setCompany(Company c) {
    put("company", c);
}
...