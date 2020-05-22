//and in my Groovy script:
@groovy.transform.TypeChecked
def main() {
  def c1 = new Child1()
  c1.value1 = 1
  c1.parentVal = 2;

  def c2 = new Child2()
  c2.value2 = 2
  c2.parentVal = 3;

  def myCol = new MyCollection<Child1>()

  myCol.add(c1)
  //myCol.add(c2) // doesn't compile
}


main()