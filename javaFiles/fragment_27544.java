@Configuration
public class ApplicationConfig {

@Autowired
ApplicationContext applicationContext;

@Bean
public SheetPool sheetPool() {
    SheetPool pool = new SheetPool();

    IntStream.range(0, 10).forEach(e -> {
        pool.getSheets().add((Sheet) applicationContext.getBean("sheet"));
    });

    return pool;
}