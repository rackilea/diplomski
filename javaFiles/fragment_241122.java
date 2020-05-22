boolean isFirst = true;
StringBuilder res = new StringBuilder();
for (Map.Entry<String, Object> entry : properties.entrySet()) {
    if (!isFirst) {
        res.append(", ");
    }
    isFirst = false;
    res.append(entry.getKey());
    res.append(":'");
    res.append(entry.getValue());
    res.append("'");
}