void doGet(...) {
    StringBuilder var = new StringBuilder();
    addH(var);
    addI(var);
    resp.write(var.toString());
}

void addH(StringBuilder var) {
    var.append('h');
}

void addI(StringBuilder var) {
    ver.append('i');
}