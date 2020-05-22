int data = reader.read();
while(data != -1) {
    result += (char) data;
    data = reader.read();
}
reader.close();