for (String keyword : keywords_tobe_checked) {
    boolean hasKeyword = false;
    for (String value : array) {
        if (value.contains(keyword)) {
            hasKeyword = true;
            break;
        }
    }

    Assert.assertTrue(hasKeyword, "The keyword " + keyword + " is in the list");
}