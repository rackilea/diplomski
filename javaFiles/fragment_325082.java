String text = "CALDARI_STARSHIP_ENGINEERING";
    text = text.replace("_", " ");
    StringBuilder out = new StringBuilder();
    for (String s : text.split("\\b")) {
        if (!s.isEmpty()) {
            out.append(s.substring(0, 1) + s.substring(1).toLowerCase());
        }
    }
    System.out.println("[" + out.toString() + "]");
    // prints "[Caldari Starship Engineering]"