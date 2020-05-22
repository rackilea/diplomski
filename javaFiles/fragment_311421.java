// but. Custom comparator can make all the difference
    Comparator<JsonNode> cmp = new Comparator<JsonNode>() {
        @Override
        public int compare(JsonNode o1, JsonNode o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            if ((o1 instanceof NumericNode) && (o2 instanceof NumericNode)) {
                double d1 = ((NumericNode) o1).asDouble();
                double d2 = ((NumericNode) o2).asDouble();
                if (d1 == d2) { // strictly equals because it's integral value
                    return 1;
                }
            }
            return 0;
        }
    };
    // but with custom comparator, yes
    assertTrue(root1.equals(cmp, root2));