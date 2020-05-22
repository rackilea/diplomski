import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import junit.framework.Assert;

public class TestDateSPEL {

@Test
public void testCompareDate() throws Exception {
    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
    String otherDate = "2010-12-25 12:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withZone(ZoneId.systemDefault());
    ZonedDateTime zdtOtherDate = ZonedDateTime.parse(otherDate, formatter);
    //SpEL Context
    EvaluationContext context = new StandardEvaluationContext(new ZonedDateTimeUtil());
    context.setVariable("dateOne", zonedDateTime);
    context.setVariable("dateTwo", zdtOtherDate);
    //SpEL Parser
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("compareDate(#dateOne, #dateTwo)");
    int value = (Integer) exp.getValue(context);
    //"zonedDateTime" is after "zdtOtherDate"
    Assert.assertEquals(1, value);
  }
}

class ZonedDateTimeUtil {
public int compareDate(ZonedDateTime dateOne, ZonedDateTime dateTwo){
    return dateOne.compareTo(dateTwo);
   }
}