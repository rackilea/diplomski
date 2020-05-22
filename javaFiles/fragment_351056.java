static {
    validForms.add(new SimpleDateFormat("MM/dd/yyyy"));
    validForms.add(new SimpleDateFormat("MM/dd/yy"));
    for (SimpleDateFormat f : validForms) {
        f.setLenient(false);
    }
}