public class DataObject
{
    private Content content;

    private class Content
    {
        private String name1;
        private Object[][][] name2;
        private String name3;

        public String getName1()
        {
            return name1;
        }

        public Object[][][] getName2()
        {
            return name2;
        }

        public String getName3()
        {
            return name3;
        }

        public void setName1(
            final String newValue)
        {
            name1 = newValue;
        }

        public void setName2(
            final Object[][][] newValue)
        {
            name2 = newValue;
        }

        public void setName3(
            final String newValue)
        {
            name3 = newValue;
        }
    }

    public Content getContent()
    {
        return content;
    }


    public void setContent(
        Content content)
    {
        this.content = content;
    }
}