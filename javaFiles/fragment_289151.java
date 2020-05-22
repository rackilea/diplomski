final PrintWriter writer = new PrintWriter(System.out);

try {
    com.strobel.decompiler.Decompiler.decompile(
        "W:\\Hello.class",
        new com.strobel.decompiler.PlainTextOutput(writer)
    );
}
finally {
    writer.flush();
}