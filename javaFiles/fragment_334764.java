public void test() throws IOException
{
    SimplePdfCreator creator = new SimplePdfCreator(new FileOutputStream("target/test-outputs/SimpleGenerated.pdf"));

    creator.print(100, 500, "Test line 1");
    creator.print("Test line 2");

    creator.color(1, 0, 0);
    creator.backColor(0, 1, 1);
    creator.print(100, 450, "Test line red");
    creator.color(0, 1, 0);
    creator.backColor(1, 0, 1);
    creator.print("Test line green");
    creator.color(0, 0, 1);
    creator.backColor(1, 1, 0);
    creator.print("Test line blue");

    creator.color(1, 1, 1);
    creator.backColor(0, 0, 0);

    creator.print(100, 400, "step");
    creator.print(100 + (int)creator.getStringWidth("step"), 400 - creator.getLeading(), "by");
    creator.print(100 + (int)creator.getStringWidth("stepby"), 400 - 2 * creator.getLeading(), "step");

    creator.storePage();

    creator.print(100, 400, "Page 2");

    creator.storePage();

    creator.close();
}