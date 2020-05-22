import java.util.EnumSet;
import static java.util.EnumSet.complementOf;

for (EnumThing t : complementOf(EnumSet.of(thing))) {
  ... do the work ...
}