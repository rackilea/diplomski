public boolean equals(Object o) {
    if (o == null)
        return false;
    if (!(o instanceof Employee))
        return false;

    Employee emp = (Employee) o;
    if (emp.name.equalsIgnoreCase(this.name))
        return true;
    else
        return false;
}