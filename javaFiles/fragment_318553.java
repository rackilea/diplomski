Diff diff=XMLUnit.compareXML(Expected,Actual);
    diff.overrideDifferenceListener(new DifferenceListener() {
       public void skippedComparison(Node arg0, Node arg1) {
       }

       public int differenceFound(Difference difference) {
        if (difference.getControlNodeDetail().getXpathLocation().contains("entry")) {
            return DifferenceListener.RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
        } else {
            return DifferenceListener.RETURN_ACCEPT_DIFFERENCE;
        }
        }
    });
XMLAssert.assertXMLIdentical(diff,true);