import play.*;
import play.data.format.Formatters;
import play.libs.Json;

import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import java.text.ParseException;

/**
 * Fixes for play application. TODO remove this once Play has fixed support for LocalDate
 * @author Sean van Buggenum
 *
 */
public class GlobalFixes extends GlobalSettings
{   // One can see from the javadoc of java.time.LocalDate that the toString guarantees this format, regardless of locale!
    private static final Pattern datePattern = Pattern.compile("(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)");

    public void onStart(Application app)
    {
        //https://groups.google.com/forum/#!topic/play-framework/Wl_ip56111c
        Formatters.register(LocalDate.class, new Formatters.SimpleFormatter<LocalDate>()
        {
            @Override
            public LocalDate parse(String input, Locale l) throws ParseException
            {
                Matcher m = datePattern.matcher(input);
                if (!m.matches())
                    throw new ParseException("No valid Input for date text: " + input, 0);
                return LocalDate.of(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
            }

            @Override
            public String print(LocalDate localTime, Locale l)
            {
                return localTime.toString();
            }
        });

        // Add Json's java 8 support
        // http://stackoverflow.com/questions/32872474/how-to-use-java-time-localdate-on-a-play-framework-json-rest/32891177#comment56814598_32891177
        // https://groups.google.com/forum/?hl=en.#!searchin/play-framework/java.time.localdate/play-framework/Dv-IpvBqWgo/l6NTp3e0BQAJ
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JSR310Module());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Json.setObjectMapper(mapper);
    }
}