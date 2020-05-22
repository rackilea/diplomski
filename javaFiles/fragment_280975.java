/**
  * @param id Wicket id of component to find
  * @param n 1-based
  * @tparam T class of component to find
  * @return the Nth component of class T appearing on the lastRenderedPage
  */
def findNthComponentOnPage[T <: Component : ClassTag](id: String, n: Int): T = {
  tester.getLastRenderedPage.visitChildren(classTag[T].runtimeClass, new IVisitor[T, T] {
    var count = 0

    override def component(checkbox: T, visit: IVisit[T]): Unit = {
      if (checkbox.getId == id) {
        count += 1
        if (count == n) {
          visit.stop(checkbox)
        }

      }
    }
  })
}