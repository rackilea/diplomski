object Test {
  class SomeClass {
    @InjectExt(id = "someCoolId") val myMember = 2
    @InjectExt(id = "someOtherCoolId") val myOtherMember = 2
  }

  def getFieldId(fieldName: String, someInstance: SomeClass): String = {
    val myMember = someInstance.getClass.getDeclaredField(fieldName)
    myMember.getDeclaredAnnotation(classOf[InjectExt]).id()
  }

  def main(args: Array[String]): Unit = {
    println(getFieldId("myMember", new SomeClass))
    println(getFieldId("myOtherMember", new SomeClass))
  }
}