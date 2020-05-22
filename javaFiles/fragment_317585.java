@Override
public void onResponse(String response)
{
    AsyncTask.execute(new Runnable() {

        @Override
        public void run()
        {
            synchronized (MyClassName.class) {
                if (!response.equals(Properties.PRODUCT_NOT_FOUND)
                        || !response.equals(Properties.USER_NOT_FOUND)) {
                    if (user.getFavoriteProducts().contains(product.getId())) {
                        user.getFavoriteProducts().remove(product.getId());

                    } else {
                        user.getFavoriteProducts().add(product.getId());
                    }

                    mSharedPreferencesManager.insertUser(user);
                }
            }
        }
    });
}