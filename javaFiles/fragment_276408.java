@Root(name = "telegram")
@Convert(Telegram.TelegramConverter.class) // Requires AnnotationStrategy
public class Telegram
{
    private Map<String, String> config;


    public String get(String name)
    {
        return config.get(name);
    }

    public Map<String, String> getConfig()
    {
        return config;
    }

    // ...

    @Override
    public String toString()
    {
        return "Telegram{" + "config=" + config + '}';
    }




    static class TelegramConverter implements Converter<Telegram>
    {
        @Override
        public Telegram read(InputNode node) throws Exception
        {
            Telegram t = new Telegram();

            final InputNode config = node.getNext("config");
            t.config = new HashMap<>();

            // Iterate over config's child nodes and put them into the map
            InputNode cfg = config.getNext();

            while( cfg != null )
            {
                t.config.put(cfg.getName(), cfg.getValue());
                cfg = config.getNext();
            }

            return t;
        }

        @Override
        public void write(OutputNode node, Telegram value) throws Exception
        {
            // Implement if you need serialization too
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}