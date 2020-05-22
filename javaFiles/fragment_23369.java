private static class ExludeEmptyObjects{
        @Override
        public boolean equals(Object o) {
            if (o instanceof Map) {
                return ((Map) o).size() == 0;
            }
            if (o instanceof Collection) {
                return ((Collection) o).size() == 0;
            }
            return false;
        }
    }