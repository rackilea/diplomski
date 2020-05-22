public void buildClassifier(Instances train) throws Exception {
    ...
    // missing values   
    m_ReplaceMissingValues = new ReplaceMissingValues();
    m_ReplaceMissingValues.setInputFormat(train);
    train = Filter.useFilter(train, m_ReplaceMissingValues);
    ...
}