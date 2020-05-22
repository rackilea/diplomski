public class MainActivity extends AppCompatActivity {

    DiaryDatabaseHelper diaryDatabaseHelper, attachedDiaryDatabaseHelper;

    String currentAttachedDBName;

    AllinOneDatabaseHelper allinOneDatabaseHelper;
    ArrayList<GenericPlantDatabaseHelper> multiDBGenericPlantDatabaseHelperArrayList = new ArrayList<>();

    Spinner multiDBHelpersSpinner, attachedDBSpinner, singleDBSpinner;
    SimpleCursorAdapter multiDBHelpersDiaryAdapter, attachedDBDiaryAdapter, singleDBDiaryAdapter,
            multiDBHelpersPlantAdapter, attachedDBPlantAdapter, singleDBPlantAdapter;
    ListView multiDBHelpersListView, attachedDBListView, singleDBListView;
    Cursor multiDBHelpersDiaryCursor, attachDBDiaryCursor, singleDBDiaryCursor,
            multiDBHelpersPlantCursor, attachedDBPlantCursor, singleDBPlantCursor
            ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Get View Id's */
        multiDBHelpersSpinner = this.findViewById(R.id.multiDBHelpersSpinner);
        attachedDBSpinner = this.findViewById(R.id.attachedDatabasesSpinner);
        singleDBSpinner = this.findViewById(R.id.singleDatabaseSpinner);
        multiDBHelpersListView = this.findViewById(R.id.multiDBHelpersListView);
        attachedDBListView = this.findViewById(R.id.attachedDatabasesListView);
        singleDBListView = this.findViewById(R.id.singleDatabaseListView);

        allinOneDatabaseHelper = new AllinOneDatabaseHelper(this);
        attachedDiaryDatabaseHelper = new DiaryDatabaseHelper(this,true);
        diaryDatabaseHelper = new DiaryDatabaseHelper(this);
        multiDBHelpersDiaryCursor = diaryDatabaseHelper.getAllDiaryRows();
        while (multiDBHelpersDiaryCursor.moveToNext()) {
            multiDBGenericPlantDatabaseHelperArrayList.add(new GenericPlantDatabaseHelper(
                    this,
                    multiDBHelpersDiaryCursor.getString(multiDBHelpersDiaryCursor.getColumnIndex(Diary.COLUMN_DIARYNAME)),
                    "")
            );
        }

        manageMultiDBHelpersSpinner();
        manageAttachedDBSpinner();
        manageSingleDBSpinner();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (multiDBHelpersDiaryCursor != null && !multiDBHelpersDiaryCursor.isClosed()) {
            multiDBHelpersDiaryCursor.close();
        }
        if (attachDBDiaryCursor != null && !attachDBDiaryCursor.isClosed()) {
            attachDBDiaryCursor.close();
        }
        if (singleDBDiaryCursor != null && !singleDBDiaryCursor.isClosed()) {
            singleDBDiaryCursor.close();
        }
        allinOneDatabaseHelper.close();
        diaryDatabaseHelper.close();
    }

    private void manageMultiDBHelpersSpinner() {
        multiDBHelpersDiaryCursor = diaryDatabaseHelper.getAllDiaryRows();
        if (multiDBHelpersDiaryAdapter == null) {
            multiDBHelpersDiaryAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    multiDBHelpersDiaryCursor,
                    new String[]{Diary.COLUMN_DIARYNAME},
                    new int[]{android.R.id.text1},
                    0
            );
            multiDBHelpersSpinner.setAdapter(multiDBHelpersDiaryAdapter);
            multiDBHelpersSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    manageMultiDBHelpersListView(
                            multiDBHelpersDiaryCursor.getString(
                                    multiDBHelpersDiaryCursor.getColumnIndex(
                                            Diary.COLUMN_DIARYNAME)
                            )
                    );
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
            multiDBHelpersDiaryAdapter.swapCursor(multiDBHelpersDiaryCursor);
        }
    }

    private void manageMultiDBHelpersListView(String diaryName) {
        for (GenericPlantDatabaseHelper g: multiDBGenericPlantDatabaseHelperArrayList) {
            if (g.getCurrentDatabaseName().equals(GenericPlantDatabaseHelper.BASEDBNAME + diaryName)) {
                multiDBHelpersPlantCursor = g.getAllPlants();
            }
        }
        if (multiDBHelpersPlantAdapter == null) {
            multiDBHelpersPlantAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    multiDBHelpersPlantCursor,
                    new String[]{GenericPlantDatabaseHelper.Plant.COLUMN_PLANTNAME},
                    new int[]{android.R.id.text1},
                    0
            );
            multiDBHelpersListView.setAdapter(multiDBHelpersPlantAdapter);
        } else {
            multiDBHelpersPlantAdapter.swapCursor(multiDBHelpersPlantCursor);
        }
    }

    private void manageAttachedDBSpinner() {
        attachDBDiaryCursor = attachedDiaryDatabaseHelper.getAllDiaryRows();
        if (attachedDBDiaryAdapter == null) {
            attachedDBDiaryAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    attachDBDiaryCursor,
                    new String[]{Diary.COLUMN_DIARYNAME},
                    new int[]{android.R.id.text1},
                    0
            );
            attachedDBSpinner.setAdapter(attachedDBDiaryAdapter);
            attachedDBSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    manageAttachedListView(
                            attachDBDiaryCursor.getString(
                                    attachDBDiaryCursor.getColumnIndex(Diary.COLUMN_DIARYNAME)
                            )
                    );
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
            attachedDBDiaryAdapter.swapCursor(attachDBDiaryCursor);
        }
    }

    private void manageAttachedListView(String diaryName) {
        String dbfilename;
        String dbname;
        SQLiteDatabase db = attachedDiaryDatabaseHelper.getWritableDatabase();
        GenericPlantDatabaseHelper g = new GenericPlantDatabaseHelper(this,diaryName,GenericPlantDatabaseHelper.ATTACHEXTRA);
        dbfilename = this.getDatabasePath(g.getDatabaseName()).getPath();
        dbname = g.getDatabaseName();
        g.close();
        if (currentAttachedDBName != null && !dbname.equals(currentAttachedDBName)) {
            detachAll(db);
        }
        currentAttachedDBName = dbname;
        db.execSQL("ATTACH DATABASE '" + dbfilename + "' AS '" + dbname + "'");
        attachedDBPlantCursor = db.query(GenericPlantDatabaseHelper.Plant.TABLENAME,null,null,null,null,null,null);
        if (attachedDBPlantAdapter == null) {
            attachedDBPlantAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    attachedDBPlantCursor,
                    new String[]{GenericPlantDatabaseHelper.Plant.COLUMN_PLANTNAME},
                    new int[]{android.R.id.text1},
                    0
            );
            attachedDBListView.setAdapter(attachedDBPlantAdapter);
        } else {
            attachedDBPlantAdapter.swapCursor(attachedDBPlantCursor);
        }

    }

    private void detachAll(SQLiteDatabase db) {
        db =  attachedDiaryDatabaseHelper.getWritableDatabase();
        Cursor csr = db.query("pragma_database_list",null,"lower(name) <> 'main' AND name <> 'temp'",null,null,null,null);
        while (csr.moveToNext()) {
            db.execSQL("DETACH DATABASE " + csr.getString(csr.getColumnIndex("name")));
        }
    }

    private void manageSingleDBSpinner() {
        singleDBDiaryCursor = allinOneDatabaseHelper.getAllDiaries();
        if (singleDBDiaryAdapter == null) {
            singleDBDiaryAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    singleDBDiaryCursor,
                    new String[]{Diary.COLUMN_DIARYNAME},
                    new int[]{android.R.id.text1},
                    0
            );
            singleDBSpinner.setAdapter(singleDBDiaryAdapter);
            singleDBSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    manageSingleDBListView(id);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
            singleDBDiaryAdapter.swapCursor(singleDBDiaryCursor);
        }
    }

    private void manageSingleDBListView(long diaryId) {
        singleDBPlantCursor = allinOneDatabaseHelper.getPlantsPerDiaryId(diaryId);
        if (singleDBPlantAdapter == null) {
            singleDBPlantAdapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_2,
                    singleDBPlantCursor,
                    new String[]{AllinOneDatabaseHelper.singleDBPlant.COLUMN_PLANTNAME,AllinOneDatabaseHelper.singleDBPlant.COLUMN_PLANTOWNERID},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    0
            );
            singleDBListView.setAdapter(singleDBPlantAdapter);
        } else {
            singleDBPlantAdapter.swapCursor(singleDBPlantCursor);
        }
    }
}