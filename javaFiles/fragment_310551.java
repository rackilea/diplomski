public void swapRow(int a, int b) {
        int ai = 0, bi = 0;
        for (final Index i : rows_) {
            if (i.getIndex() == a) {
                ai = rows_.indexOf(i);
            }
            if (i.getIndex() == b) {
                bi = rows_.indexOf(i);
            }
        }
        final Index aidx = rows_.get(ai);
        rows_.set(ai, rows_.get(bi));
        rows_.set(bi, aidx);

    }