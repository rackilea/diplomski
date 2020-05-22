static List<String> mergeLetters(List<String> items){
    Map<String, List<String>> mergingCandidates = new HashMap<>();
    for (String s : items) {
        int length = s.length();
        if (length > 1 && Character.isLetter(s.charAt(length - 1))) {
            String key = s.substring(0, length - 1);
            String value = s.substring(length - 1);
            List<String> tmp = mergingCandidates.computeIfAbsent(key, k -> new LinkedList<String>());
            tmp.add(value);
        }
    }

    for (Map.Entry<String, List<String>> entry : mergingCandidates.entrySet()) {
        String key = entry.getKey();
        List<String> characterList = entry.getValue();
        if (characterList.size() > 1) {
            boolean consecutive = true;
            Character[] characters = characterList.stream().map(s -> s.charAt(0)).toArray(Character[]::new);
            for (int i = 0; i < characters.length - 1; i++) {
                if (characters[i + 1] - characters[i] != 1) {
                    consecutive = false;
                    break;
                }
            }
            if (consecutive) {
                int indexToBeReplaced = items.indexOf(key + characterList.get(0));
                String newValue = key + "[" + characterList.get(0)
                        + "-" + characterList.get(characterList.size() - 1) + "]";
                characterList.forEach(letter -> items.remove(key + letter));
                items.add(indexToBeReplaced, newValue);
            }
        }
    }
    return items;
}