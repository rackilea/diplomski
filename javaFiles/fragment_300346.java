private boolean canShowProgress(){
        LogCat.d(TAG, "canShowProgress");
        Class<ProgressBar> barclz = ProgressBar.class;
        try {
            Method method = barclz.getMethod("setVisibility", new Class[]{int.class});
            Class c = null;
            try {
                c = Class.forName("android.view.RemotableViewMethod");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return (this.showProgress= (c != null && method.isAnnotationPresent(c)));


        } catch (SecurityException e) {
            LogCat.stackTrace(TAG, e);
        } catch (NoSuchMethodException e) {
            LogCat.stackTrace(TAG, e);

        }
        return false;
    }