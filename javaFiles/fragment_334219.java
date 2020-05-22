public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    TextView textView;
    Button btn;
    Time st;
    Kind sk;
    Hardship sh;
    Lang sl;
    String text;

    String spin1 = "";
    String spin2 = "";
    String spin3 = "";
    String spin4 = "";

    double num1;
    double num2;
    double num3;
    double num4;

    double res = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        textView = findViewById(R.id.result);
        btn = findViewById(R.id.btnresult);


        ArrayAdapter<Time> spinnerArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, new Time[]{

                new Time(1, "عادی"),
                new Time(1.5, "نیمه فوری"),
                new Time(2, "فوری")
        });

        spinner.setAdapter(spinnerArrayAdapter);


        ArrayAdapter<Kind> spinner1ArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, new Kind[]{

                new Kind(1, "مهندسی"),
                new Kind(2, "علوم اسلامی"),
                new Kind(1.5, "فلسفه"),
                new Kind(1.5, "حقوق و اسناد تجاری"),
                new Kind(1.25, "پزشکی"),
                new Kind(1, "سایر رشته ها")
        });

        spinner1.setAdapter(spinner1ArrayAdapter);

        ArrayAdapter<Hardship> spinner2ArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, new Hardship[]{

                new Hardship(1, "عمومی"),
                new Hardship(1.2, "تخصصی")
        });

        spinner2.setAdapter(spinner2ArrayAdapter);

        ArrayAdapter<Lang> spinner3ArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, new Lang[]{

                new Lang(1.5, "عربی"),
                new Lang(1.5, "فرانسه"),
                new Lang(1.5, "آلمانی"),
                new Lang(1.5, "ترکی استانبولی"),
                new Lang(1.5, "ترکی آذری"),
                new Lang(1.5, "روسی"),
                new Lang(1.5, "ارمنی"),
                new Lang(1.75, "اسپانیایی"),
                new Lang(1.75, "ایتالیایی"),
                new Lang(1.75, "کردی"),
                new Lang(2, "چینی"),
                new Lang(2, "کره ای"),
                new Lang(2, "ژاپنی"),
                new Lang(2, "اردو"),
                new Lang(2, "مجاری"),
                new Lang(2, "سوئدی"),
                new Lang(2, "هلندی"),
                new Lang(2, "تاجیک"),
                new Lang(2, "لهستانی")
        });

        spinner3.setAdapter(spinner3ArrayAdapter);


        spinner3.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner1.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(this);


        btn.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                res =37* (num1 * num2 * num3 * num4);
                textView.setText(res + "");
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner:
                Time time = (Time) spinner.getSelectedItem();
                num1 = time.id;
                spin1 = time.name;

                break;

            case R.id.spinner1:
                Kind kind = (Kind) spinner1.getSelectedItem();
                num2 = kind.id;
                spin2 = kind.name;


                break;
            case R.id.spinner2:
                Hardship hardship = (Hardship) spinner2.getSelectedItem();
                num3 = hardship.id;
                spin3 = hardship.name;
                break;


            case R.id.spinner3:
                Lang lang = (Lang) spinner3.getSelectedItem();
                num4 = lang.id;
                spin4 = lang.name;

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public class Time {

        public double id;
        public String name;

        public Time(double _id, String _name) {
            id = _id;
            name = _name;
        }

        public String toString() {
            return name;
        }
    }

    public class Kind {


        public double id;
        public String name;

        public Kind(double _id, String _name) {
            id = _id;
            name = _name;
        }

        public String toString() {
            return name;
        }


    }

    public class Hardship {

        public double id;
        public String name;

        public Hardship(double _id, String _name) {
            id = _id;
            name = _name;
        }

        public String toString() {
            return name;
        }
    }

    public class Lang {

        public double id;
        public String name;

        public Lang(double _id, String _name) {
            id = _id;
            name = _name;
        }

        public String toString() {
            return name;
        }
    }

}