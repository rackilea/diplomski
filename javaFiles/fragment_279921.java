public void testMethod() {
  Form expected = new Form()
                    .field1('value1')
                    .field2('value2')
                    .field3('value3')
                    .field4('value4')

  Form result = someFormOperation();

  softAssert(expected, result);

}