public class MainActivity extends AppCompatActivity {

protected <A extends Fragment & IBaseFragment, B extends Fragment & IBaseFragment> void init(Class<A> classA, Class<B> classB) {
    TabLayout tab = (TabLayout) findViewById(R.id.tab);
    ViewPager pager = (ViewPager) findViewById(R.id.pager);
    SynthesisFragmentAdapter<A, B> fragmentAdapter = new SynthesisFragmentAdapter<>(getSupportFragmentManager(), this, classA, classB);
    pager.setAdapter(fragmentAdapter);
    tab.setupWithViewPager(pager);
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init(FragmentA.class, FragmentB.class);
}

interface IBaseFragment {
}


public static class FragmentA extends Fragment implements IBaseFragment {
}


public static class FragmentB extends Fragment implements IBaseFragment {

}

public class SynthesisFragmentAdapter<A extends Fragment & IBaseFragment, B extends Fragment & IBaseFragment> extends FragmentPagerAdapter {


    private Context context;

    private Class<A> synthesisFragmentClass1;

    private Class<B> synthesisFragmentClass2;

    public SynthesisFragmentAdapter(FragmentManager fm, Context context,
                                    Class<A> synthesisFragmentClass1,
                                    Class<B> synthesisFragmentClass2) {
        super(fm);
        this.context = context;
        this.synthesisFragmentClass1 = synthesisFragmentClass1;
        this.synthesisFragmentClass2 = synthesisFragmentClass2;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }
}