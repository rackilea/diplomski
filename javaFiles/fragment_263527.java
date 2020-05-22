String s = "c5|208971|YAhj56|thoimn|10/8/79|T|w11511329801500";
    String string = null;
    if (s.contains("=")) {
        string = s.substring(s.lastIndexOf("=") + 1);
    } else {
        string = s.substring(s.lastIndexOf("|") + 1);
    }
    if (string.length() >= 13) {
        string = string.substring(0, 13);
    }