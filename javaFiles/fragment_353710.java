@RunWith(MockitoJUnitRunner.class)
 public class TestMapper {

 @Mock
 OutputCollector<Text, IntWritable> output;

 @Mock
 Reporter reporter;

 @Test
 public void testMap() throws Exception {
    ExampleClass.MapClass mapper = new ExampleClass.MapClass();
    mapper.map(new LongWritable(0), new Text("1"), output, reporter);
    mapper.map(new LongWritable(0), new Text("2"), output, reporter);
    mapper.map(new LongWritable(0), new Text("3"), output, reporter);
    verify(output, times(1)).collect(new Text("key"), new IntWritable(1));
    verify(output, times(1)).collect(new Text("key"), new IntWritable(2));
    verify(output, times(1)).collect(new Text("key"), new IntWritable(3));
 }

 @Test
 public void testReduce() throws Exception {
    ExampleClass.Reduce reducer = new ExampleClass.Reduce();
    List<IntWritable> list = Arrays.asList(new IntWritable(1), new IntWritable(2), new IntWritable(3));

    reducer.reduce(new Text("key"), list.iterator(), output, reporter);

    verify(output, times(1)).collect(new Text("key"), new IntWritable(3));
 }
}