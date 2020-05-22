Filter filter = new Filter() {

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return resultValue.toString();
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if( charSequence == null ) return null;
            try {
                // This call hits the server with the name I'm looking for and parses the JSON returned for the first 25 results
                PagedResult results = searchByName( charSequence.toString(), 1, 25, true);
                FilterResults filterResults = new FilterResults();
                filterResults.values = results.getResults();
                filterResults.count = results.getResults().size();
                return filterResults;
            } catch (JSONException e) {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if( filterResults != null ) {
                adapter.clear();
                adapter.addAll( (List<MyObject>)filterResults.values );
            }
        }
    };