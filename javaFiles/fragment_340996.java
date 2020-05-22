@Mock
private HBaseRowKeyDistributor hDist;

@Mock
private HTable table;

@Test
public void sampleTest(){

    //Mock data and external calls

    final byte [] COL_FAMILY = "a".getBytes();
    final byte [] COL_QUALIFIER = "co_created_5076".getBytes();

    List<KeyValue> kvs =new ArrayList<KeyValue>();
    kvs.add(new KeyValue(COL_FAMILY, COL_QUALIFIER,
                           Bytes.toBytes("ExpedtedBytes")));
     Result result = new Result(kvs);

     byte[] rowKey = "Hello".getBytes();
     when(hdist.getDistributedKey(anyString()).thenReturn(rowKey);

     when(table.get(any(Get.class))).thenReturn(result);

     //Call the actual method
     calloriginalUnitTestingMethod();


     //Now Verify the result using Mockito verify like
     verify(...)

     //You could also intercept the attributes

}