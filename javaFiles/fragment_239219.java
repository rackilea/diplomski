String[] parts = line.split("_");
        byte[] bytes = parts[1].getBytes("UTF-8");
        String japaneseString = new String(bytes, "UTF-8");
        Log.d("voc", japaneseString);
        adjectives_ej.put(parts[2].replaceAll(" ",""), new String(bytes, "UTF-8"));
        adjectives_je.put(new String(bytes, "UTF-8"), parts[2].replaceAll(" ",""));