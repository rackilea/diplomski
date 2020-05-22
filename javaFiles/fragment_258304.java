public static void main(String[] args) throws IOException, SAXException {
    final Match $m = $(new File(args[0]));
    $m.namespace("android", "http://schemas.android.com/apk/res/android")
            .xpath("//view[@android:id='@+id/view4']")
            .attr("custom:sliderLabel", "Custom SLider Label");
    $m.write(System.out);
}