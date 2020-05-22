String protocol = "http";
String host = "example.com";
String location = "/path/path?key1=value1&key2=value2#fragment";

// Split the location without removing the delimiters
String[] parts = location.split("(?=\\?)|(?=#)");

String path = null;
String query = null;
String fragment = null;

// Iterate over the parts to find path, query and fragment
for (String part : parts) {

    // The query string starts with ?
    if (part.startsWith("?")) {
        query = part.substring(1); 
        continue;
    }

    // The fragment starts with #
    if (part.startsWith("#")) {
        fragment = part.substring(1);
        continue;
    }

    // Path is what's left
    path = part;
}

URI uri = new URI(protocol, host, path, query, fragment);