List<String> data = new ArrayList<String>();

while ((currentLine = br.readLine()) != null) {
    data.add(currentLine);
}

return data.toArray(new String[data.size()]);  // or just return the list?