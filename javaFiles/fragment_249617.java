public class MainActivity extends Activity {

    private SimpleDateFormat mSimpleDateFormat;
    private PeriodFormatter mPeriodFormat;

    private Date startDate;
    private Date endDate;
    private Date birthDate;


    private TextView tvStartDate,tvEndDate,tvDifferenceStandard,tvDifferenceCustom,tvBirthDate,tvAgeStandard,tvAgeCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        //determine dateDiff
        Period dateDiff = calcDiff(startDate,endDate);
        tvDifferenceStandard.setText(PeriodFormat.wordBased().print(dateDiff));
        tvDifferenceCustom.setText( mPeriodFormat.print(dateDiff));


        //determine age
        Period age = calcDiff(birthDate,new Date());
        tvAgeStandard.setText(PeriodFormat.wordBased().print(age));
        tvAgeCustom.setText( mPeriodFormat.print(age));

    }

    private void init() {

        //ui
        tvStartDate = (TextView)findViewById(R.id.tvStartDate);
        tvEndDate = (TextView)findViewById(R.id.tvEndDate);
        tvDifferenceStandard = (TextView)findViewById(R.id.tvDifferenceStandard);
        tvDifferenceCustom = (TextView)findViewById(R.id.tvDifferenceCustom);
        tvBirthDate = (TextView)findViewById(R.id.tvBirthDate);
        tvAgeStandard = (TextView)findViewById(R.id.tvAgeStandard);
        tvAgeCustom = (TextView)findViewById(R.id.tvAgeCustom);



        //components
        mSimpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        mPeriodFormat = new PeriodFormatterBuilder().appendYears().appendSuffix(" year(s) ").appendMonths().appendSuffix(" month(s) ").appendDays().appendSuffix(" day(s) ").printZeroNever().toFormatter();


        try {
            startDate = mSimpleDateFormat.parse(tvStartDate.getText().toString());
            endDate =  mSimpleDateFormat.parse(tvEndDate.getText().toString());
            birthDate = mSimpleDateFormat.parse(tvBirthDate.getText().toString());

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Period calcDiff(Date startDate,Date endDate)
    {
        DateTime START_DT = (startDate==null)?null:new DateTime(startDate);
        DateTime END_DT = (endDate==null)?null:new DateTime(endDate);

        Period period = new Period(START_DT, END_DT);

        return period;

    }

}