while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if (line.contains(":")) {
                        if (key != null) {
                            values.put(key, value.trim());
                            key = null;
                            value = null;
                        }
                        int indexOfColon = line.indexOf(":");
                        key = line.substring(0, indexOfColon);
                        value = line.substring(indexOfColon + 1);
                    } else {
                        value += " " + line;
                    }
                }
                if (key != null) {
                    values.put (key, value.trim());
                }