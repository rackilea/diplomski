@SpringBootApplication
public class DemoApplication implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<LocalDateTime>() {
            final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            @Override
            public LocalDateTime parse(String text, Locale locale) throws ParseException {
                return LocalDateTime.from(dtFormatter.parse(text));
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return dtFormatter.format(object);
            }
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}