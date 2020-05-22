public enum DirectoriesActivity {
    DELETE ("D"),
    REPLACE ("R"),
    ADD_NEW_CONTENTS ("A");

    private String directoriesActivityCode;

    private DirectoriesActivity(String directoriesActivityCode)    {
        this.directoriesActivityCode = directoriesActivityCode;
    }    

    public DirectoriesActivity getEnum(String x){
        for (DirectoriesActivity directoriesActivity : values()) {
            if (directoriesActivity.directoriesActivityCode.equals(x)) {
                return directoriesActivity;
            }
        }
        throw new IllegalArgumentException("Unknown value " + x);
    }
}