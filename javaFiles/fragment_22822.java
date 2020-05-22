private boolean isKoreanHangul(int codepoint) {
    Character.UnicodeBlock block = Character.UnicodeBlock.of(codepoint);
    return (Character.UnicodeBlock.HANGUL_JAMO.equals(block) ||
            Character.UnicodeBlock.HANGUL_JAMO_EXTENDED_A.equals(block) || // api 19
            Character.UnicodeBlock.HANGUL_JAMO_EXTENDED_B.equals(block) || // api 19
            Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(block) ||
            Character.UnicodeBlock.HANGUL_SYLLABLES.equals(block));
}