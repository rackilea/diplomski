public class ThemeUtil {

public static final int THEME_DEFAULT=1;
public static final int THEME_DARK=2;
public static final int ALERTTHEME=3;
public static final int ALERTTHEMEDARK=4;



public static int getThemeId(int theme){
    int themeId=0;
    switch (theme){

        case THEME_DARK:
            themeId = R.style.AppTheme_Dark;
            break;

        case THEME_DEFAULT :
            themeId = R.style.AppTheme;
            break;

        default:
            break;
    }
    return themeId;
}}