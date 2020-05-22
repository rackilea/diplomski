Iterator<String> iter = client.iterator();
StringBuilder sb = new StringBuilder();

while (iter.hasNext()) {
    sb.append("'").append(iter.next()).append("'");
    if (iter.hasNext())
        sb.append(",");
}
return sb.toString();