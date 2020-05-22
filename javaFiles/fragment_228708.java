@Root(name = "PickLineXtra")
@Convert(PickXtra.PickXtraConverter.class)
public class PickXtra
{
    private final String key;
    private String value;

    public PickXtra(String key, String value)
    {
        this.key = key;
        this.value = value;
    }


    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "PickXtra{" + "key=" + key + ", value=" + value + '}';
    }


    /* 
     * !===> This is the actual part <===!
     */
    static class PickXtraConverter implements Converter<PickXtra>
    {
        @Override
        public PickXtra read(InputNode node) throws Exception
        {
            /*
             * Get the right attribute here - for testing the first one is used.
             */
            final String attrKey = node.getAttributes().iterator().next();
            final String attrValue = node.getAttribute(attrKey).getValue();

            return new PickXtra(attrKey, attrValue);
        }

        @Override
        public void write(OutputNode node, PickXtra value) throws Exception
        {
            node.setAttribute(value.key, value.getValue());
        }
    }
}