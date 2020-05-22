import java.time._

path = Paths.get("C://Users//xxx//token.txt");
attributes = Files.readAttributes(path, BasicFileAttributes.class);
lastModifiedTime = attributes.lastModifiedTime().toInstant()
currentTime = Instant.now()

diffInMins = Duration.between(lastModifiedTime, currentTime).toMinutes()