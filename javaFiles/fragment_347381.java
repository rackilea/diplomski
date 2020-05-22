StringBuilder result = new StringBuilder();

while ((line = reader.readLine()) != null) {
    result.append(line);
}

reader.close();
out.write(result);