trait DBObject
trait AggDBObject extends DBObject
trait RawDBObject extends DBObject

class Dimensions1Agg extends AggDBObject {
  // Put the custom code you had at `initDataPoints`
}

class Dimensions2Agg extends AggDBObject {
  // Put the custom code you had at `initDataPoints`
}

class Dimensions1Raw extends RawDBObject {
  // Put the custom code you had at `initDataPoints`
}


class DataContext(var summaryData: DBObject) {

  var XByDateData : Map[String, DBObject] = _

  def restrictAccess = {
    // .. some impl ..
  }
}

object DataContext {
  /** This is your main builder function.
    * This version IS polymorphic, your data context holds a DBObject of the right type, but callers don't need to know which one. */
  def apply(sId: Int, mId: Int): DataContext  = {

    (sId, mId) match {
      case (1, 1) => new DataContext(new Dimensions1Agg())
      case (1, 2)  => new DataContext(new Dimensions2Agg())
      //... add more cases and a default case.
    }
  }
}