Multiset<String> ngrams = HashMultiset.create();
//added strings to the multiset...

    ngrams.setCount(terms, Integer.MAX_VALUE);

    for (Multiset.Entry<String> entry : ngrams.entrySet()) {
        if (entry.getElement().equals(terms)) {
            continue;
        }
        if (entry.getCount() > 3) {
            ngrams.setCount(terms, 3);
        }
    }

    if (ngrams.count(terms) == Integer.MAX_VALUE) {
        ngrams.setCount(terms, 0);
    }