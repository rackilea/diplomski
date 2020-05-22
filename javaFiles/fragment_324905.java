Diff xmlDiff = new Diff(s1, s2);
xmlDiff.overrideElementQualifier(new ElementNameQualifier() {
        @Override
        protected boolean equalsNamespace(Node control, Node test) {
            return true;
        }
    });
xmlDiff.overrideDifferenceListener(new DifferenceListener() {
        @Override
        public int differenceFound(Difference diff) {
            if (diff.getId() == DifferenceConstants.NAMESPACE_URI_ID) {
                return RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
            }
            return RETURN_ACCEPT_DIFFERENCE;
        }
        @Override
        public void skippedComparison(Node arg0, Node arg1) { }
    });