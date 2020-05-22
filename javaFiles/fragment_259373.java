class Test
{
    enum MyEnum
    {
        BRAND_1("A brand"),
        BRAND_2("A second brand"),
        BRAND_3("A third brand");

        private String st;

        MyEnum(String s)
        {
            this.st = s;
        }

        void change(String newString)
        {
            this.st = newString;
        }

        String getContent()
        {
            return this.st;
        }
    }

    public static void main(String...args)
    {
        MyEnum c1 = MyEnum.BRAND_2;

        c1.change("A magic brand!");

        System.out.println(MyEnum.BRAND_2.getContent());
    }
}