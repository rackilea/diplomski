@Override
public String toString() {
   StringBuilder builder = new StringBuilder();
   builder.append(this.getName()).append(", ");
   builder.append(this.getGender()).append(", ");
   return builder.toString();
}