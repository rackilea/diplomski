public void setAdmin(Class<? extends Administrable> admin) {
    if (admin != null && !Administrable.class.isAssignableFrom(admin)) {
        throw new IllegalArgumentException("The parameter " + admin.getName() + " should be administrable.");
    }
    this.admin = admin;
}