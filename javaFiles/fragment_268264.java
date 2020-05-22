public static void Write(Document document, File input) throws IOException {
        // lets write to a file
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(input), format);
        writer.write(document);
        writer.close();
        // Pretty print the document to System.out
        writer = new XMLWriter(System.out, format);
        writer.write(document);
        // Compact format to System.out
        format = OutputFormat.createCompactFormat();
        writer = new XMLWriter(System.out, format);
        writer.write(document);
    } //END Write