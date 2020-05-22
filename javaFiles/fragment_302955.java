@Test
public void testHandleIn() throws Exception
{
  IPDO pdo = new PDODummy();


  MyClass handler = new MyClass ();
  MyClass handler2 = spy(handler);

  doReturn(pdo ).when( handler2 ).getIPDO();
  PDOUtil.setPDO(pdo, LogicalFieldEnum.P_TX_CTGY, "test123");
  IPDO pdoNew = handler2.getIPDO();

  Assert.assertEquals("test123,(PDOUtil.getValueAsString(pdoNew, LogicalFieldEnum.P_TX_CTGY)));

}