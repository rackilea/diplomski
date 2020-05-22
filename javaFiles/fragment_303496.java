class ControllerIntentBuilder
{
    public static Intent create(Content context, int requestCode, int resultCode, Intent resultIntent)
    {

        String contents = resultIntent.getStringExtra("SCAN_RESULT");

        Data data = new Data(contents);

        String formatName = intent.getStringExtra("SCAN_RESULT_FORMAT");
        if (data.Matrix(contents, formatName))
        {
            Intent activityIntent = new Intent(context, ReportActivity.class);
            activityIntent.putExtra("IdValue", data.getId());
            activityIntent.putExtra("PerfValue", data.getPerf());
            activityIntent.putExtra("MpIdValue", data.getMpId());

            return activityIntent;
        }

        // and so on for other conditions
    }

}