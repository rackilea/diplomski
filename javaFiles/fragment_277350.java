public String toString() {
     StringBuilder sb = new StringBuilder("Person:\n");
     sb.append("ID: ").append(this.getId()).append("\n")
        append("Full name: ").append(this.getFullName()).append("\n")
        append("Age: ").append(this.getAge()).append("\n");
     return sb.toString();
}