boolean isString = false;
        char[] text = code.toCharArray();
        for (int i = 0; i < text.length; i++) {
            if (text[i] == '\"') {
                isString = !isString;
                if(!isString) {
                    document.setCharacterAttributes(i, 1, attributes, true);
                }
            }
            if (isString) {
                document.setCharacterAttributes(i, 1, attributes, true);
            }
        }