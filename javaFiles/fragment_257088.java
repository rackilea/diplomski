try {
        ContentResolver contentResolver = this.getContentResolver();

        InputStream inputStream = contentResolver.openInputStream(data);
        Scanner scanner = new Scanner(inputStream).useDelimiter("\n");

        String nextLine = scanner.nextLine();
        List<RainfallRecord> records = new ArrayList<>();

        if (nextLine.matches("^[A-Za-z]"));
            nextLine = scanner.nextLine();

        while (scanner.hasNext()) {
            String[] rainData = nextLine.split(",");
            nextLine = scanner.nextLine();
            records.add(getRecord(rainData, strategy));
        }

        db.recordDao().insertAll(records);
    } catch (IOException ex) {
        ex.printStackTrace();
        Toast.makeText(this.getApplicationContext(), "Error processing file", Toast.LENGTH_LONG).show();
    }