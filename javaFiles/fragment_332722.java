StringBuilder data = new StringBuilder(128);

String text = null;
while ((text = reader.readLine()) != null) {
    data.append(text).append("\n"); // if you're interested in the new line character
}

return data.toString();