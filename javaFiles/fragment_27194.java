public class MyClass{
    public static final ItemStack myItem = new ItemStack(Material.BOOK) {

        {
            addEnchantment(Enchantment.ARROW_DAMAGE, 1);
        }

    };
}