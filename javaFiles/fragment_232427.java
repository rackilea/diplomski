// Assume the ArrayList is named stringList
StringBuilder buffer = new StringBuilder();
for(String current : stringList) {
    buffer.append(current).append("\n");
}

BufferedReader br = new BufferedReader(new StringReader(buffer.toString()));