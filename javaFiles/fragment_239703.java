@Override
protected Void doInBackground(Void... params) {
   try {
       doc = GetDocument(website1);
   } catch (Exception e) {
       e.printStackTrace();
   }

   return null;
}