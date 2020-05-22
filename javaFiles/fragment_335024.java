FileInputStream input = new FileInputStream(file);
    InputStreamReader reader = new InputStreamReader(input, "utf-8");
    FileOutputStream output = new FileOutputStream(destinationFile);
    OutputStreamWriter writer = new OutputStreamWriter(output, "Windows-1250");

    int read = reader.read();
    while (read != -1)
    {
        writer.write(read);
        read = reader.read();
    }