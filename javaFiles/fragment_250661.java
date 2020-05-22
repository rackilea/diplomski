List<String> finalSentence = Arrays.stream(entryParts)
        .map(word -> {
            if (ignoredWords.contains(word)) {
                return word;
            }
            return WordUtils.capitalize(word);
        })
        .collect(Collectors.toList());