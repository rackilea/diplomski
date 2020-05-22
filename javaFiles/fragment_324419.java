protected void onPostExecute(Document doc) {
        super.onPostExecute(doc);
        setStatus(getStatus(doc));
        if (mDirectionListener != null) {
            mDirectionListener.onResponse(doc,
                    GoogleDirection.this);
        }