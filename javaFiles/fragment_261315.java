File in = ...;
File out = ...;

InputStream input = new FileInputStream(in);
try {
    OutputStream output = new FileOutputStream(out);
    try {
        copy(input, output);
    }
    finally {
        output.close();
    }
}
finally {
    input.close();
}