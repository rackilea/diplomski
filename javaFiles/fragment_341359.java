URI uri = new URI(
        "http", 
        "www.google.com", 
        "/ig/api",
        "weather=São Paulo",
        null);
String request = uri.toASCIIString();