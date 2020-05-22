public class FragmentStyleSubCatMain extends Fragment {

// handle variables for each dynamic xml object utilized in this [sub-category] activity
private TextView header, featured;
private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10, rb11, rb12;
private CheckBox cbAdditives;
publie static int mButtonId;// use this line

 @Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_style_sub_cat_left, container, false);

    // initialize the dynamic xml objects from this [sub-category] activity
    header = (TextView) getView().findViewById(R.id.tv_header);
    rb1 = (RadioButton) getView().findViewById(R.id.radioButton1);
    rb2 = (RadioButton) getView().findViewById(R.id.radioButton2);
    rb3 = (RadioButton) getView().findViewById(R.id.radioButton3);
    rb4 = (RadioButton) getView().findViewById(R.id.radioButton4);
    rb5 = (RadioButton) getView().findViewById(R.id.radioButton5);
    rb6 = (RadioButton) getView().findViewById(R.id.radioButton6);
    rb7 = (RadioButton) getView().findViewById(R.id.radioButton7);
    rb8 = (RadioButton) getView().findViewById(R.id.radioButton8);
    rb9 = (RadioButton) getView().findViewById(R.id.radioButton9);
    rb10 = (RadioButton) getView().findViewById(R.id.radioButton10);
    rb11 = (RadioButton) getView().findViewById(R.id.radioButton11);
    rb12 = (RadioButton) getView().findViewById(R.id.radioButton12);
    featured = (TextView) getView().findViewById(R.id.tv_featured);
    cbAdditives = (CheckBox) getView().findViewById(R.id.cb_additives);

    // retrieve "put extra" data from BrowseStyle class intent call
    // extra data is the button id that was clicked
    Intent mIntent = getIntent();
    // 0 is the default id


    /* this switch statement will set the appropriate header text that needs to be displayed and
       call the appropriate method that will set the text and visibility of the radio buttons
     */
    switch (mButtonId)//use button Id like this
    {
        case 0:
            // error handling if button id is invalid
            header.setText("Something went wrong");
            break;
        case R.id.b_lager_and_light_ales:
            header.setText(R.string.lagers);
            setLagerAndLightAlesRB();
            break;
        case R.id.b_wheat_ales:
            header.setText(R.string.wheats);
            setWheatAlesRB();
            break;
        case R.id.b_pale_ales_and_ipas:
            header.setText(R.string.pales);
            setPaleAlesAndIPAsRB();
            break;
        case R.id.b_belgian_ales:
            header.setText(R.string.belgians);
            setBelgianAlesRB();
            break;
        case R.id.ambers_and_browns:
            header.setText(R.string.ambers);
            setAmbersAndBrownsRB();
            break;
        case R.id.b_porters_and_stouts:
            header.setText(R.string.porters);
            setPortersAndStoutsRB();
            break;
        case R.id.b_strong_ales_and_barleywines:
            header.setText(R.string.strongs);
            setStrongAlesAndBarleywinesRB();
            break;
        case R.id.b_sours:
            header.setText(R.string.sours);
            setSoursRB();
            break;
        case R.id.b_ciders_and_meads:
            header.setText(R.string.ciders);
            setCidersAndMeadsRB();
            break;
    }
    return view;

}