public String toString() {
     StringBuilder sb = new StringBuilder("Person:\n");
     sb.append("name: ").append(this.getName()).append("\n")
        append("surname: ").append(this.getSurname()).append("\n");
     return sb.toString();
}