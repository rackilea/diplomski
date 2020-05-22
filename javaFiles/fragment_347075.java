public final class Persistence {
    private final SharedPreferences sharedPreferences;

    public Persistence(Context context) {
        sharedPreferences = context.getSharedPreferences("houseTapper_dataSaveFile", MODE_PRIVATE);
    }

    public void saveData(Player player) {
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putInt("money", player.money);
        sharedPreferencesEditor.putInt("MPS", player.MPS);
        sharedPreferencesEditor.putInt("MPC", player.MPC);
        // etc...
        sharedPreferencesEditor.apply();
    }

    public void getData(Player player) {
        player.money = sharedPreferences.getInt("money", 0);
        player.MPS = sharedPreferences.getInt("MPS", 0);
        player.MPC = sharedPreferences.getInt("MPC", 0);
        // etc...
    }    
}