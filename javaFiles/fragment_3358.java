IDocument document = ... get document

String partitioning = IJavaPartitions.JAVA_PARTITIONING;

int start = ... start offset

int length = ... length of area

ITypedRegion[] regions = TextUtilities.computePartitioning(document, partitioning, start, length, false);