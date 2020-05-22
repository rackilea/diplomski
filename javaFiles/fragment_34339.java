public static class ConditionallyFilter
      extends PTransform<PCollection<LogRow>, PCollection<LogRow>> {
  private final String date;
  public ConditionallyFilter(String date){
    this.date = date;
  }
  @Override
  public PCollection<LogRow> expand(PCollection<LogRow> logs) {
    if(!date.equals("")){
      logs = logs.apply("FilterOnDate", ParDo.of(new DateFilterFn(date)));
    }
    return logs;
  }
} 


// Read File
PCollection<LogRow> logs = p.apply("LoadData", TextIO.read().from(options.getInput())).apply(new ConditionallyFilter(date)).apply(...