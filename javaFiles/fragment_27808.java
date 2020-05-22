public static class Holder {
        private final Filters data;

        public Holder(Filters data) {
            this.data = data;
        }

        public Filters getData() {
            return data;
        }
    }

    public static class Filters {
        private final Map<String, Value> filters;

        public Filters(Map<String, Value> filters) {
            this.filters = filters;
        }

        public Map<String, Value> getFilters() {
            return filters;
        }
    }

    public static class Value {
        private final String label;
        private final int order;

        public Value(String label, int order) {
            this.label = label;
            this.order = order;
        }

        public String getLabel() {
            return label;
        }

        public int getOrder() {
            return order;
        }
    }