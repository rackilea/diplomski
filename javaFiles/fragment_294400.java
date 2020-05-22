@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee)) return false;
    Employee employee = (Employee) o;
    return id == employee.id && job == employee.job && name.equals(employee.name);

}

@Override
public int hashCode() {
    int result = id;
    result = 31 * result + name.hashCode();
    result = 31 * result + job.hashCode();
    return result;
}