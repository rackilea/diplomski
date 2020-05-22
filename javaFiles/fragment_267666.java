Set<UnicodeBlock> chineseUnicodeBlocks = new HashSet<UnicodeBlock>() {{
    add(UnicodeBlock.CJK_COMPATIBILITY);
    add(UnicodeBlock.CJK_COMPATIBILITY_FORMS);
    add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
    add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
    add(UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
    add(UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
    add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
    add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
    add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
    add(UnicodeBlock.KANGXI_RADICALS);
    add(UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS);
}};

String mixedChinese = "查詢促進民間參與公共建設法（210ＢＯＴ法）";

for (char c : mixedChinese.toCharArray()) {
    if (chineseUnicodeBlocks.contains(UnicodeBlock.of(c))) {
        System.out.println(c + " is chinese");
    } else {
        System.out.println(c + " is not chinese");
    }
}