LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
RelativeLayout mFrame = (RelativeLayout)inflater.inflate(R.layout.results, null);   
//Now you can use/reference its resources/views etc.
final EditText showLog = (EditText)mFrame.findViewById(R.id.etShowLog);
showLog.setFocusable(false);
final Button btnClearWin = (Button) mFrame.findViewById(R.id.btnClear);
final Button btnSaveTrip = (Button) mFrame.findViewById(R.id.btnSave);