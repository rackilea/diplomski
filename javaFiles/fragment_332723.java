StringBuilder data = new StringBuilder(128);

int charsIn = -1;
char buffer = new char[1024];
while ((charsIn = reader.read(buffer)) > -1) {
    data.append(buffer, 0, charsIn);
}

return data;