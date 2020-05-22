import java.time.Duration;
import java.time.Instant;

...

Instant start = Instant.now()

// here waiting for user input, very simplified, just an example
System.in.read();

Instant end = Instant.now();
Duration duration = Duration.between(start, end);