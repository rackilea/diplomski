StringBuilder sb = new StringBuilder();
for (int i = 0, rowCount = matrixOne.size(); i < rowCount; i++) {
    ArrayList<ArrayList<T>> row = matrixOne.get(i);
    sb.append(row.toString()
        .replaceAll("\\[\\[|\\]|,|\\[|\\]\\]", "")
        .replace(" ", "\t"));
    sb.append("\n");
}
return sb.toString();