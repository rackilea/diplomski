@Override 
public void onCreate(Bundle savedInstanceState) 
{ 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.YOUR_LAYOUT); 

    //...

    CheckBox checkboxMovies = (CheckBox)findViewById(R.id.chkInterestsMovies);
    checkboxMovies.setOnCheckedChangeListener(this);
    CheckBox checkboxAnimals = (CheckBox)findViewById(R.id.chkInterestsAnimals);
    checkboxAnimals.setOnCheckedChangeListener(this);
    CheckBox checkboxShopping = (CheckBox)findViewById(R.id.chkInterestsShopping);
    checkboxShopping.setOnCheckedChangeListener(this);
    CheckBox checkboxBooks = (CheckBox)findViewById(R.id.chkInterestsBooks);
    checkboxBooks.setOnCheckedChangeListener(this);
    CheckBox checkboxRestaurants = (CheckBox)findViewById(R.id.chkInterestsRestaurants);
    checkboxRestaurants.setOnCheckedChangeListener(this);
    CheckBox checkboxComputers = (CheckBox)findViewById(R.id.chkInterestsComputers);
    checkboxComputers.setOnCheckedChangeListener(this);
    CheckBox checkboxTV = (CheckBox)findViewById(R.id.chkInterestsTV);
    checkboxTV.setOnCheckedChangeListener(this);
    CheckBox checkboxPubs = (CheckBox)findViewById(R.id.chkInterestsPubs);
    checkboxPubs.setOnCheckedChangeListener(this);
    CheckBox checkboxDancing = (CheckBox)findViewById(R.id.chkInterestsDancing);
    checkboxDancing.setOnCheckedChangeListener(this);

    //...
}