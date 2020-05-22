FileReader fr1 = new FileReader(f1);
    FileReader fr2 = new FileReader(f2);
    XMLUnit.setCompareUnmatched(false);
    Diff diff = new Diff(fr1, fr2);
    System.out.println("Similar? " + diff.similar());
    System.out.println("Identical? " + diff.identical());

    DetailedDiff detDiff = new DetailedDiff(diff);

    detDiff.overrideDifferenceListener(new DifferenceListener() {
        @Override
        public int differenceFound(Difference diff) {
            if (diff.getId() == DifferenceConstants.CHILD_NODELIST_SEQUENCE_ID
                || diff.getId() == DifferenceConstants.CHILD_NODELIST_LENGTH_ID) {
                return RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
            }
            return RETURN_ACCEPT_DIFFERENCE;
        }
        @Override
        public void skippedComparison(Node arg0, Node arg1) { }

    });


    List differences = detDiff.getAllDifferences();
    for (Object object : differences) {
        Difference difference = (Difference)object;
        System.out.println("***********************");
        if (difference.getId() == DifferenceConstants.CHILD_NODE_NOT_FOUND_ID) {
            if (difference.getControlNodeDetail().getNode() == null) {
                System.out.println("Node was added");
            } else {
                System.out.println("Node was removed");
            }
        }
        System.out.println("***********************");
    }