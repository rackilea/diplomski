public static String hslToColor(int alpha, float hue, float saturation, float lightness) {

    ...

    // !!! ERROR WAS ON THE LAST LINE:
    return String.format("#%08x", resultColorInt).toUpperCase();
}