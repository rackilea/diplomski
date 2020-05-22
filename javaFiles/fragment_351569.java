@Override
    public void onItemClick(AdapterView<?> adapter, View curview, int position,
            long id) {
        WhoisEntry entry = this.adapter.getItem(position);      
        long event_id = CalendarUtils.getNewEventId(getContentResolver(), null);

        Toast.makeText(getApplicationContext(), "Domain: " + entry.getDomainName(),
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", entry.getExpiration().getTime());
        intent.putExtra("_id", event_id);
        intent.putExtra("allDay", false);       
        intent.putExtra("endTime", entry.getExpiration().getTime()+60*30);
        intent.putExtra("title", "Expiration of " + entry.getDomainName());
        startActivity(intent);

        database.insertDomainEntry(entry.getExpiration(),
                entry.getDomainName(), event_id);
    }