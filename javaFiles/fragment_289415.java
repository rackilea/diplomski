// Assuming this:
import static org.jooq.impl.DSL.*;

using(configuration)
   .deleteFrom(MY_TABLE)
   .where(row(MY_TABLE.FIRST, MY_TABLE.LAST).notIn(
        row("Joe", "Smith"),
        row("Mark", "Taylor")
   ))
   .execute();