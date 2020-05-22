private boolean isJapaneseKana(int codepoint) {
    Character.UnicodeBlock block = Character.UnicodeBlock.of(codepoint);
    return (
            Character.UnicodeBlock.HIRAGANA.equals(block) ||
            Character.UnicodeBlock.KATAKANA.equals(block) ||
            Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS.equals(block));
}