Can you put some sample data so it will be clear about your requirement.
As I understood from your question you need to filter those rows which has name as 'clarke' and story-type as 'gif'.
This can be implemented using Scan class with additional filters as

SingleColumnValueFilter filter_by_name = new SingleColumnValueFilter( 
                   Bytes.toBytes("name" ),
                   Bytes.toBytes("name"),
                   CompareOp.EQUAL,
                   Bytes.toBytes("clarke"));
SingleColumnValueFilter filter_by_story = new SingleColumnValueFilter( 
                   Bytes.toBytes("story_type" ),
                   Bytes.toBytes("type"),
                   CompareOp.EQUAL,
                   Bytes.toBytes("gif"));

FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
filterList.addFilter(filter_by_name);
filterList.addFilter(filter_by_story);

Scan scan = new Scan();
scan.setFilter(filterList);

ResultScanner scanner = table.getScanner(scan);
Result result = scanner.next;

// now use iteration to print the complete value.. if you are interested only in count then just iterate and increment count
int gifCount =0;
while(result != null)
{
  gifCount ++;
result =scanner.next;
}
println(gifCount);