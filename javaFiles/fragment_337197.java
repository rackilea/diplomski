if (line.contains("downstream_rm(j,l)")) {
            String replacement = line;
            while (!replacement.matches(".*?/.*?/.*?")) {
                replacement += scanner.nextLine();
            }
            String raw = "";
            for (int index = 0; index < strarray.size(); index++) {

                String s = strarray.get(index);
                raw = raw + "\n" + s;
            }
            String raw2 = raw.replaceAll(",", "");
            line = replacement.replaceAll("/.*?/", "/" + raw2 + "/");
        }