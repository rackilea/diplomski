public void execute(Realm realm){
        for (int i = 0; i<menuListArray.length(); i++ ){
            try{
                JSONObject jObject = menuListArray.getJSONObject(i);
                user.setMenuTitle(jObject.getString("title"));
                realm.copyToRealm(user);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(getApplication(), ProfileLandingActivity.class);
        startActivity(intent);
        finish();
    }