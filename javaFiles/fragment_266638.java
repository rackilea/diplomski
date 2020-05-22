public class OnlineProductList extends AsyncTask<Void,Void,Void>{
        private WeakReference<Context> contextRef;

        public OnlineProductList(Context context) {
            contextRef = new WeakReference<>(context);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            System.out.println("Program: " + productData.length / 3 + " Products found");

//create product objects



            Product[] product = new Product[productData.length / 3];
            for (int i = 0; i < product.length; i++) {

                product[i] = new Product(productData[3 * i], productData[1 + 3 * i], Boolean.parseBoolean(productData[2 + 3 * i]));

            }

            //create buttons for available products

            Context context = contextRef.get();
            if (context != null) {
                MainActivity.productButton = new Button[product.length];

                for (int i = 0; i < productData.length; i++) {

                    MainActivity.productButton[i] = new Button(this);
                    MainActivity.productButton[i].setWidth(MainActivity.orderHorizontalLayout.getWidth());
                    MainActivity.productButton[i].setHeight(MainActivity.orderHorizontalLayout.getHeight() / 10);
                    MainActivity.productButton[i].setText(product[i].name);

                    MainActivity.orderHorizontalLayout.addView(MainActivity.productButton[i]);
                }
            }
        }
    }