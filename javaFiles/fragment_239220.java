String[] parts = line.split("_");
            String japaneseString = parts[1].trim();
            String englishString = parts[2].trim();

            Log.d("voc", japaneseString + " : " + englishString);

            adjectives_ej.put(englishString, japaneseString);
            adjectives_je.put(japaneseString, englishString );