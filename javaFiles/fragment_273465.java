class Item
{
    public final String name;
    public final int price;

    public Item(final String name, final int price)
    {
        this.name = name;
        this.price = price;
    }

    public int getQty(final int budget)
    {
        return budget / price;
    }
}

class Main
{
    public static void main(String... args)
    {
        final List<Item> items = Arrays.asList(
            new Item("Popcorn", 10_000), // always a rip-off
            new Item("Water", 1),
            new Item("Juice", 3)
        );

        final int money = 10;

        for (final Item item : items)
        {
            final int qty = item.getQty(money);
            if (qty > 0) // exclude things we can't buy
            {
                System.out.println("You can buy " + qty + " " + item.name);
            }
        }
    }
}