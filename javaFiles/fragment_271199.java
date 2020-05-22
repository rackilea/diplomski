Diff diff = new Diff(docx1, docx2);
        DifferenceEngine engine = new DifferenceEngine(diff);

        ElementQualifier qualifier = new RecursiveElementNameAndTextQualifier();
        diff = new Diff(docx1, docx2, engine, qualifier);
        diff.overrideDifferenceListener(new DifferenceListener()
        {
            @Override public int differenceFound(Difference difference)
            {
                // Do some thing here


            }

            @Override public void skippedComparison(Node node, Node node1)
            {
                //no op
            }
        });