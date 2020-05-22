public double [] distributionForInstance(Instance instance) throws Exception {
    // line 710
    m_ReplaceMissingValues.input(instance);
    instance = m_ReplaceMissingValues.output();
    ...
}