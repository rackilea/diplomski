private class InsertAndVerifyDataTask extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... params) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            long endTime = calendar.getTimeInMillis();
            calendar.add(Calendar.YEAR, -1);
            long startTime = calendar.getTimeInMillis();

        DataReadRequest dataReadRequest = new DataReadRequest.Builder()
                .read(DataType.TYPE_WEIGHT)
                .setTimeRange(startTime, endTime, TimeUnit.MILLISECONDS)
                .setLimit(1)
                .build();


 DataReadResult dataReadResult = Fitness.HistoryApi.readData(mApiClient, dataReadRequest).await(1000, TimeUnit.MILLISECONDS);

if (dataReadResult.getBuckets().size() > 0) {
            Log.i(TAG, "Number of returned buckets of DataSets is: "
                    + dataReadResult.getBuckets().size());

            for (Bucket bucket : dataReadResult.getBuckets()) {
                List<DataSet> dataSets = bucket.getDataSets();

                for (DataSet dataSet : dataSets) {
                    dumpDataSet(dataSet);

                }
            }
        } else if (dataReadResult.getDataSets().size() > 0) {
            Log.i(TAG, "Number of returned DataSets is: "
                    + dataReadResult.getDataSets().size());

            for (DataSet dataSet : dataReadResult.getDataSets()) {
                dumpDataSet(dataSet);
            }
        }
            return null;
        }
    }

private void dumpDataSet(DataSet dataSet) {
        for (DataPoint dp : dataSet.getDataPoints()) {
            List<Field> field = dp.getDataType().getFields();
            if (field.get(0).getName().equalsIgnoreCase("activity")) {
                if (dp.getValue(field.get(0)).asActivity()
                        .equalsIgnoreCase("walking")) {
                    walkingTime = TimeUnit.MILLISECONDS.toSeconds(dp.getValue(
                            field.get(1)).asInt());

                    Log.e("walking", walkingTime + "");
                }

                if (dp.getValue(field.get(0)).asActivity()
                        .equalsIgnoreCase("biking")) {
                    cyclingTime = TimeUnit.MILLISECONDS.toSeconds(dp
                            .getValue(field.get(1)).asInt());

                    Log.e("biking", cyclingTime + "");
                }
                if (dp.getValue(field.get(0)).asActivity()
                        .equalsIgnoreCase("in_vehicle")) {
                    travelingTime = TimeUnit.MILLISECONDS.toSeconds(dp
                            .getValue(field.get(1)).asInt());
                    Log.e("in_vehicle", travelingTime + "");
                }
                if (dp.getValue(field.get(0)).asActivity()
                        .contains("running")) {
                    runningTime = TimeUnit.MILLISECONDS.toSeconds(dp
                            .getValue(field.get(1)).asInt());

                    Log.e("running", runningTime + "");
                }
            } else if (field.get(0).getName().equalsIgnoreCase("steps")) {

                steps = dp.getValue(field.get(0)).asInt();

                Log.e("steps", "" + steps);
            }
        }
    }