@Target(TYPE)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {TicketPresenceValidator.class})
public @interface AtLeastOneTicket {
}


public class TicketPresenceValidator implements ConstraintValidator<AtLeastOneTicket, TicketInfo> {
 @Override
 public void initialize(TicketInfo constraintAnnotation) {
 }

 @Override
 public boolean isValid(TicketInfo ticketInfo, 
                        ConstraintValidatorContext context) {
    return ticketInfo.getSize() != 0;
 }
}