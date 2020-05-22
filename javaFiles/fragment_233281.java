Intent i = new Intent(this, GameDanska.class);

switch (getResources().getDisplayMetrics().densityDpi) {
    case DisplayMetrics.DENSITY_MEDIUM:
        i.putExtra("myMethod", "nextQuestionMDPI");
        startActivity(i);
        break;
    default:
        i.putExtra("myMethod", "nextQuestionHDPI");
        startActivity(i);
        break;
}