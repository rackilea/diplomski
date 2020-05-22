@Override
        protected void onPostExecute(ArrayList<String> o) {
            secondArray.clear();
            secondArray.addAll(o);
            Toast.makeText(MainActivity.this, secondArray.get(0), Toast.LENGTH_LONG).show();
        }