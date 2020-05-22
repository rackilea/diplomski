import java.sql.Clob;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.Embedded.Nullable;

@Configuration
@EnableJdbcRepositories
public class AggregateJdbcConfiguration extends AbstractJdbcConfiguration {

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {

        return new JdbcCustomConversions(Arrays.asList(new Converter<Clob, String>() {

            @Nullable
            @Override
            public String convert(Clob clob) {

                try {

                    return Math.toIntExact(clob.length()) == 0 //
                            ? "" //
                            : clob.getSubString(1, Math.toIntExact(clob.length()));

                } catch (SQLException e) {
                    throw new IllegalStateException("Failed to convert CLOB to String.", e);
                }
            }
        }));
    }
}