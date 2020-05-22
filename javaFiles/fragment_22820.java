private boolean isCJK(int codepoint) {
    Character.UnicodeBlock block = Character.UnicodeBlock.of(codepoint);
    return (
            Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS.equals(block)||
            Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A.equals(block) ||
            Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B.equals(block) ||
            Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C.equals(block) || // api 19
            Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D.equals(block) || // api 19
            Character.UnicodeBlock.CJK_COMPATIBILITY.equals(block) ||
            Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS.equals(block) ||
            Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS.equals(block) ||
            Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT.equals(block) ||
            Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT.equals(block) ||
            Character.UnicodeBlock.CJK_STROKES.equals(block) ||                        // api 19
            Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION.equals(block) ||
            Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS.equals(block) ||
            Character.UnicodeBlock.ENCLOSED_IDEOGRAPHIC_SUPPLEMENT.equals(block) ||    // api 19
            Character.UnicodeBlock.KANGXI_RADICALS.equals(block) ||
            Character.UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS.equals(block));
}