@Override
public String toString() {
    return "Person{" +
            "address='" + address + '\'' +
            ", name='" + name + '\'' +
            ", spouse=" + spouse != null ? spouse.getName() : " {none}" +
            '}';
}