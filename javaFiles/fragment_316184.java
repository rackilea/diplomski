public String toString() { 
    String result = value;
    if (next != null) {
        result += " ; " + next.toString();
    }
    return result;
}