// Collect emojis
String content = message.getContentRaw();
List<String> emojis = EmojiParser.extractEmojis(content);
List<String> customEmoji = message.getEmotes().stream()
        .map((emote) -> emote.getName() + ":" + emote.getId())
        .collect(Collectors.toList());

// Create merged list
List<String> merged = new ArrayList<>();
merged.addAll(emojis);
merged.addAll(customEmoji);

// Sort based on index in message to preserve order
merged.sort(Comparator.comparingInt(content::indexOf));

for (String emoji : merged) {
    message.addReaction(emoji).queue();
}