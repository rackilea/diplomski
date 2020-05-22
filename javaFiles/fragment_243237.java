// class DiaryLogs
class DiaryLogs {
    ...
    @Override
    public toString() {
        return dateTime + " - " + entryName;
    }
    ...
}

// in your activity
ArrayList<DiaryLogs> diaryLogs = new ArrayList<DiaryLogs>();
diaryLogs.add(new DiaryLogs(1, "Apr. 14, 2014", "Entry 1"));
diaryLogs.add(new DiaryLogs(1, "Apr. 14, 2014", "Entry 2"));
diaryLogs.add(new DiaryLogs(1, "Apr. 14, 2014", "Entry 3"));

yourListView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, diaryLogs));