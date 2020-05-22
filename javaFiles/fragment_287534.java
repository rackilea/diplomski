public enum EnumService
{
    ONE("abc*"),
    // etc

    private static final Map<Pattern, EnumService> MAPPING
        = new HashMap<>();

    static {
        for (final EnumService svc: values())
            MAPPING.put(svc.pattern, svc);
    }

    private final Pattern pattern;

    EnumService(final String s)
    {
        pattern = Pattern.compile(s);
    }

    public static EnumService returnMockService(String request)
    {
        for (final Map.Entry<Pattern, EnumService> entry: MAPPING.entrySet())
            if (entry.getKey().matcher(request).matches())
                return entry.getValue();
        return null;
    }
}