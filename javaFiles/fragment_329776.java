try (OutputStream outputStream = socket.getOutputStream()) {
        message.writeDelimitedTo(outputStream);     
        System.out.println("Sending finished.");
    } catch (IOException e) {
        // SEE NOTES!!
        System.err.println("blah blah" + e.toString());
        System.exit(0);
    }