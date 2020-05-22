import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

Period p = Period.of(2,5,1);
DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("y 'years,' M 'months,' d 'days'");
LocalDate.of(p.getYears(), p.getMonths(), p.getDays()).format(fomatter);