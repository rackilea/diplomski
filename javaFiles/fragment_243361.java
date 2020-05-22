private class GetMakrs extends AsyncTask<Void, Void, Void> {
        String desc = ""; //<-Important!
        Elements tds;

        ...

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                 ...

            Elements description = doc.select("meta[name=description]");
             for (Element table : doc.select("table[id=scell]")) {
                for (Element row : table.select("tr:gt(0)")) {
                 Elements tds = row.select("td:not([rowspan])");
                 desc = desc + "Semester"+" "+"Attempt"+" "+" "+"Total Marks"+" "+"     Result"+" "+"                          Percentage";

                 desc = desc + "\n" + tds.get(0).text() + "        " + tds.get(1).text()+"          "+ tds.get(2).text()+"       "+tds.get(3).text()+"      "+ tds.get(4).text();

                 desc = desc + "\n";


                    }
               }
                ...
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
            TextView txtdesc = (TextView) findViewById(R.id.MarksShow);
            txtdesc.setText(desc);
            mProgressDialog.dismiss();
        }
    }