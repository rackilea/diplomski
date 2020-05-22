public <Source, Result> List<Result> convertAll(List<Source> source,
    Function<Source, Result> projection)
{
    ArrayList<Result> results = new ArrayList<Result>();
    for (Source element : source)
    {
         results.add(projection.apply(element));
    }
    return results;
}