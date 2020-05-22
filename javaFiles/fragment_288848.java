Desktop desktop = Desktop.getDesktop();
        String message = "mailto:someuser@somedomain.com?subject=mySubject&body=someBody";
        URI uri = URI.create(message);
        try {
            desktop.mail(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }