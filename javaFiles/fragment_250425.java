String[] terms = term.trim().split("\\s+");
for (int i = 0; i < terms.length; i++) {
    str += "term = '" + terms[i] + "'";
    if (i < terms.length -1) {
        str += " OR ";
    }
}