@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (InfoIndividual i : _individuals) {
        sb.append(i);
    }

    return sb.toString();
}