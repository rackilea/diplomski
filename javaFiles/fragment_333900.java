jshell> import com.fasterxml.jackson.databind.*;

jshell> import java.time.*;

jshell> import com.fasterxml.jackson.datatype.jsr310.*;

jshell> ObjectMapper mapper = new ObjectMapper();
mapper ==> com.fasterxml.jackson.databind.ObjectMapper@7fc229ab

jshell> mapper = mapper.registerModule(new JavaTimeModule());
mapper ==> com.fasterxml.jackson.databind.ObjectMapper@7fc229ab

jshell> mapper = mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
mapper ==> com.fasterxml.jackson.databind.ObjectMapper@7fc229ab

jshell> mapper.canSerialize(OffsetDateTime.class);
$7 ==> true

jshell> mapper.writeValueAsString(OffsetDateTime.now());
$8 ==> "\"2019-09-27T16:41:07.921578-07:00\""