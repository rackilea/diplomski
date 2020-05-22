public class Core extends AppCompatActivity implements Calculator.CalculatorListener{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ShoppingList mShoppingList;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ...

        mShoppingList = new ShoppingList();

    }

    @Override
    public void addtoCart(View view,String itemName, int qty, double beforeTax, double afterTax) {
        mShoppingList.setCart(view,itemName,qty,beforeTax,afterTax);
    }
}