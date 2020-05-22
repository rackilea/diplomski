public class AutomaticSpec extends BaseSpec{

  def "This is a test"(){
     when:
       def x = some value
     then:
       super.helperFunction(x) //super not needed here, just for clarity
  }
}