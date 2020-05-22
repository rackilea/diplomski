public void KillThisThenStartNewOne(){
     Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
     intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);  
     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.getApplicationContext().startActivity(intent);
        //for restarting the Activity
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
}