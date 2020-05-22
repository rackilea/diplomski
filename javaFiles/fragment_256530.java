trait DBObject
trait AggDBObject extends DBObject
trait RawDBObject extends DBObject
class Dimensions1Agg extends AggDBObject
class Dimensions2Agg extends AggDBObject
class Dimensions1Raw extends RawDBObject

class DataContext[A <: DBObject] {
  var XsummaryData: A = _
  var XByDateData : Map[String, A] = _
  def restrictAccess = {
    // .. some impl ..
  }
}

object DataContext {

  def buildDim1Agg() : DataContext[Dimensions1Agg] = {
    // Put the custom code for Dim1 you had at `initDataPoints`
    // ...
    new DataContext[Dimensions1Agg]()
  }

  // Add other builder methods if you have lots of custom code, or functions shared across builders.

  /** This is your main builder function. 
    * Note that per your request, it is not polymorphic, but tied to a specific type of DBObject.  */
  def apply(sId: Int, mId: Int): DataContext[_ <: DBObject]  = {

    (sId, mId) match {
      case (1, 1) => buildDim1Agg()
      case (1, 2)  => buildDim1Agg()
        //... add more cases and a default case.
    }
  }
}