while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] tokens = line.split("~");
        String pdf = tokens[3];
        if (pdf.equalsIgnoreCase("einfuegen_pdf")) {
            csvContent.add(tokens[5]);
        }
    }