public interface Validator<T> {
    public void validate(T object, Errors errors);
}

public class RaceInfoValidator implements Validator<RaceInfo> {
    public void validate(RaceInfo raceInfo, Error errors) {
        if (raceInfo.getRaceName() == null) {
            errors.addError("Must provide a race name.";
        } else if (raceInfo.getRaceName().isEmpty()) {
            errors.addError("The race name must not be empty.";
        }
        // etc.
    }
}

...

String race_name = ...;
...
RaceInfo raceInfo = new RaceInfo(race_name, ...);
RaceInfoValidator validator = ...;
Errors errors = ...; // write some implementation
validator.validate(raceInfo, errors);
if (errors.hasErrors()) {
    // show user the errors
}