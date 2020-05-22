import java.sql.Timestamp
import play.api.libs.functional.syntax._
import play.api.libs.json._

implicit val rds: Reads[Timestamp] = (__ \ "time").read[Long].map{ long => new Timestamp(long) }
implicit val wrs: Writes[Timestamp] = (__ \ "time").write[Long].contramap{ (a: Timestamp) => a.getTime }
implicit val fmt: Format[Timestamp] = Format(rds, wrs)

// Test it...
val testTime = Json.obj("time" -> 123456789)
assert(testTime.as[Timestamp] == new Timestamp(123456789))