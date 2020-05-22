public Iterable<T> queryInBatches(
        final String query,
        final Map<String, Integer> paramMap,
        final int pageSize, final Class<T> elementType) {
    return new Iterable<T>() {
        @Override
        public Iterator<T> iterator() {
            final Iterator<List<T>> resultIter = 
                    queryResultIterator(query, paramMap, pageSize, elementType);

            return new AbstractIterator<T>() {
                private Iterator<T> rowSet;

                @Override
                protected T computeNext() {
                    if (rowSet == null) {
                        if (resultIter.hasNext()) {
                            rowSet = resultIter.next().iterator();
                        } else {
                            return endOfData();
                        }
                    }

                    if (rowSet.hasNext()) {
                        return rowSet.next();
                    } else {
                        rowSet = null;
                        return computeNext();
                    }
                }};
        }};
}


private AbstractIterator<List<T>> queryResultIterator(
        final String query, final Map<String, Integer> paramMap, 
        final int pageSize, final Class<T> elementType) {
    return new AbstractIterator<List<T>>() {
        private int page = 0;

        @Override
        protected List<T> computeNext() {
            String sql = String.format(
                    "%s limit %s offset %s", query, pageSize, page++ * pageSize);
            List<T> results = jdbc().queryForList(sql, paramMap, elementType);
            if (!results.isEmpty()) {
                return results;
            } else {
                return endOfData();
            }
        }};
}