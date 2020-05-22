class Entry {
  ...
  ...

    public String toString() {
        return  name + "; " + (company != null ? company : "Company: null");
    }
}