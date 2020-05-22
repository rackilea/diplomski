public class NtmLoadingTask extends AsyncTask<Void, Void, Void> {

public static final String APP_DATA = "AppData";
SharedPreferences DATA;
SharedPreferences.Editor Editor;

ArrayList<String> arr_dataNtmTitles = new ArrayList<String>();
ArrayList<String> arr_dataNtmDates = new ArrayList<String>();
ArrayList<String> arr_dataNtmContents = new ArrayList<String>();

public NtmLoadingTask(Context context) {