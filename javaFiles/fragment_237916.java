try
{
      spark.sql("use schemaName")         // name of the schema
      spark.sql("select count(*) from heath1").show();
}
catch (Exception AnalysisException)
{
    System.out.print("\nTable is not found\n");
}