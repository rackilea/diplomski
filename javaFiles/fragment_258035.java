public class MyDataProvider {

    Context context;
    String test; //string variable
    ListViewItem constant_common_data[];

    //constructor for class MyDataProvider
    public MyDataProvider(Context context1){
        context=context1;
        test = context.getString(R.string.app_name);//tester string is assigned
        init_constant_common_data();        
        putInCommonMap();
        putInElectromagneticMap();

        }
        //strings for sub and superscript


        //data for common constants
    private void init_constant_common_data(){
    constant_common_data = new ListViewItem[]
                {
                        new ListViewItem(R.drawable.star, "Atomic Mass Constant " +test, "1.660 539 040 e-27", "kg", "0.000 000 020 e-27"),//test string is used, shows up as word "null" on display
                        new ListViewItem(R.drawable.star, "Avogadro Constant", "6.022 140 857 e23"," mol^-1", "0.000 000 074 x e23"),
                        new ListViewItem(R.drawable.star, "Boltzmann Constant", "1.380 648 52 e-23", "K^-1", "0.000 000 79 e-23"),
                        new ListViewItem(R.drawable.star, "Conductance Quantum", "7.748 091 7310 e-5", "s","0.000 000 0018 e-5"),
                        new ListViewItem(R.....
....
..
..

    }