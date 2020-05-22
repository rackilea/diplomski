class GetResponse {

  private List<? extends KeywordMetrics<? extends KeywordIdentifier>> metrics = null;

  public List<? extends KeywordMetrics<? extends KeywordIdentifier>> getMetrics() {
    return this.metrics;
  }

  public void setMetrics(List<? extends KeywordMetrics<? extends KeywordIdentifier>> metrics) {
    this.metrics = metrics;
  }
}