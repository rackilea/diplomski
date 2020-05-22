@Component
public class LongListConverter implements Converter<String, List<Long>> {

    @Override
    public List<Long> convert(String source) {
        return Arrays.stream(StringUtils.strip(source, "[]").split(","))
                .map(StringUtils::strip)
                .map(Long::new)
                .collect(Collectors.toList());
    }
}