Class butterKnifeClass = null;
try {
    butterKnifeClass = Class.forName("butterknife.ButterKnife");
} catch (ClassNotFoundException e) {
    // no butterknife present
}
if (butterKnifeClass != null) {
    // blah... stuff with butterknife
}