int value = 48;
int[] possibleFlags = {ApplicationInfo.FLAG_FACTORY_TEST, ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING, ApplicationInfo.FLAG_ALLOW_BACKUP};
String[] flagNames = {"FLAG_FACTORY_TEST", "FLAG_ALLOW_TASK_REPARENTING", "FLAG_ALLOW_BACKUP"};

 for (int i = 0; i < possibleFlags.length; i++) {
    int aFlag = possibleFlags[i];
    String name = flagNames[i];
    boolean hasFlag = (value & aFlag) > 0;
    Log.d("Flags", String.format("flag %s %s", name, hasFlag ? "PRESENT" : "NOT PRESENT"));
}