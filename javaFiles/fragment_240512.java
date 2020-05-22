private MyPrefs prefs;

public MyPrefs getMyPrefs(){
     if(prefs == null){
          prefs = new MyPrefs(this);
     }
     return prefs;
}