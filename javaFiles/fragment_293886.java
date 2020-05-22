query.findInBackground(new FindCallback<ParseObject>() {
        public void done(List<ParseObject> usrs, ParseException e) {
            if (e == null) {

            team_memebers = new ArrayList<String>(usrs.size());
            for (ParseObject prso:usrs) {
                team_memebers.add(new String(prso.getString("Username")));
            }
            for (String str:team_memebers)
            {
                empolyeeSpinnerAdapter.add(str);
            }
        } else {//handle the error
        }
    }
});