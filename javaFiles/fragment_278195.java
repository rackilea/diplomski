// This method always replaces malformed-input and unmappable-character sequences with this charset's default replacement string.
            String str = new String(buffer, Charset.forName("UTF-8"));
            // Replaces each occurence of "replaceThis" with "", for regex use: replaceAll(String regex, String replacement)
            str = str.replace("replaceThis", "");
            // This method always replaces malformed-input and unmappable-character sequences with this charset's default replacement byte array
            byte[] replaced = str.getBytes(Charset.forName("UTF-8"));
            while ((read = inputStream.read(buffer)) != -1)
                outputStream.write(replaced);