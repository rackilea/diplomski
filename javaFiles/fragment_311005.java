public class SomeSparkTest implements Serializable {

private static transient JavaSparkContext jsc;

@BeforeClass 
public static void init () {
    SparkConf conf = new SparkConf().setMaster("local").setAppName("testGeoHashAggregation");
    jsc = new JavaSparkContext(conf);
}

@AfterClass
public static void close(){
    jsc.close();
}

@Test 
public void shouldSomethingHappend () {
    // given 
    // preparation of RDDs
    JavaRDD<String> rdd = jsc.textFile(...)

    // when
    // actions
    long count = rdd.count()

    // then
    // verify output; assertThat is from FestAssertions, not necessary
    assertThat(count).isEqualTo(5)
}
}