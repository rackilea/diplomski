@SuppressLint("InflateParams")
    public void inflatePeriodGrade() {
        AcademicStatusController.getInstance(this);
        ArrayList<Item> periodsInfo = AcademicStatusController.getPeriodsInfo(
                instanceType, instanceId);

        // Find RelativeLayout where the period grade will be placed
        RelativeLayout llDisplayData = (RelativeLayout) findViewById(R.id.help_linear_layout_for_periods);

        View[] customViews = new View[periodsInfo.size()];
        TextView[] textViews = new TextView[periodsInfo.size()];
        //
        // Inflate the view of the period
        customViews[0] = inflater.inflate(
                R.layout.activity_academic_status_period_layout, null);
        textViews[0] = (TextView) customViews[0]
                .findViewById(R.id.academic_status_grade);

        // Set the text to the TextView.
        textViews[0].setText(((PeriodItem) (periodsInfo.get(0))).getName());
        customViews[0].setId(View.generateViewId());
        textViews[0].setId(View.generateViewId());
        llDisplayData.addView(customViews[0]);

        int i = 1;
        for (Item item : periodsInfo) {

            PeriodItem period = (PeriodItem) item;

            if (periodsInfo.get(0) == period) {
                continue;
            }

            customViews[i] = inflater.inflate(
                    R.layout.activity_academic_status_period_layout, null);
            textViews[i] = (TextView) customViews[i]
                    .findViewById(R.id.academic_status_grade);
            textViews[i].setText(period.getName());
            RelativeLayout.LayoutParams newParams;
            newParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            newParams.addRule(RelativeLayout.RIGHT_OF,
                    customViews[i - 1].getId());
            customViews[i].setId(View.generateViewId());
            textViews[i].setId(View.generateViewId());
            customViews[i].setLayoutParams(newParams);
            llDisplayData.addView(customViews[i], newParams);
            i++;
        }

    }