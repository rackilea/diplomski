int i = 0;
StringBuilder sb = new StringBuilder();
for (Map.Entry<String, Integer> counts : list) {
    sb.length(0);
    sb.append(counts.getKey());
    sb.append(",");
    sb.append(counts.getValue());
    sb.append("\n");
    fw.write(sb.toString());
    i += 1;
    if (i == 10) {
        break;
    }
}