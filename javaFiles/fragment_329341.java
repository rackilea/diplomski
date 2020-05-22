private void LoadPreferences(){
        try {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            initailizeView();
            scoreText.setText(sharedPreferences.getString("saveScore", "default"));
            wordView.setText(sharedPreferences.getString("saveWord","default"));
        }
        catch (Exception e) {
            System.err.println("scoreText or wordView are null " + e.getMessage());
        }
}