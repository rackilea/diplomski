public List<LabelUsage> labels;
...
private List<LabelUsage> preProcessUsageRecs(List<LabelUsage> usageRecs, LabelSet labelSet) {
    //Format records, use list instead strings where possible

    List<LabelSet> usageRecords = usageRecs; {
      for( LabelUsage labelUsage : usageRecs)
          usageRecords.addAll(usageRecs);
    }
    this.labels = usageRecords;
     return usageRecords;
}