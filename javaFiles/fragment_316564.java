@Override
public String toString() {
    StringBuilder sb = new StringBuilder(some_appropriate_size);
    for(Object object : ArrayList) {
        sb.append("This object is a ")
          .append(object.getVariableA())
          .append(" and a ")
          .append(object.getVariableB())
          .append(".\n");
    }
    return sb.toString();
}