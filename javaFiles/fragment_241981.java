public static void removeFragment() {
    try {
        FragmentTransaction ft = ((FragmentActivity) activityContext).getSupportFragmentManager()
                .beginTransaction();
        ft.remove((Fragment)pdMF);

        ft.commit();
    } catch (NullPointerException e) {
        e.printStackTrace();
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
}