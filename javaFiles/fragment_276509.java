//Imports
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/* //Commented as per comment about IntelliJ
spark.udf.register("date_microsec", (dt: String) => 
   val dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n")
   LocalDateTime.parse(dt, dtFormatter).getLong(ChronoField.MICRO_OF_SECOND)
)
*/

import org.apache.spark.sql.functions.udf

val date_microsec = udf((dt: String) => {
    val dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n")
    LocalDateTime.parse(dt, dtFormatter).getLong(ChronoField.MICRO_OF_SECOND)
})