StringBuilder sb = new StringBuilder();
for (Database contact : contacts) { 
    if(sb.length > 0) {
        sb.append(", ");
    }
    sb.append(contact.getMP());
}
...
sb.toString();