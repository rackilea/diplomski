public static class Reduce extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {

        Double maxValue = Double.MIN_VALUE;
        Double minvalue=Double.MAX_VALUE;
        Double a;
        while (values.hasNext()) 
        {
        a=values.next().get();
        maxValue = Math.max(maxValue,a);
        minvalue=Math.min(minvalue,a);
    if(maxValue>40)
        {
            output.collect(key,new DoubleWritable(maxValue));
        } 
   /*   if(minvalue<10)
        {
        output.collect(key, new DoubleWritable(a));
        } */

        }
    output.collect(new Text(key+"Max"), new DoubleWritable(maxValue));
    output.collect(new Text(key+"Min"),new DoubleWritable(minvalue));
    }
    }