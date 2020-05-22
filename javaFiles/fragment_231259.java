public void updateStatus() {
        List<ImageView> images = deviceListAdapter.getAllImages();
        if(count > 0 && images.size() > 0) {
            for (int i = 0; i < deviceListAdapter.getCount() ; i++) {
                Devices product = (Devices) deviceListAdapter.getItem(i);
                if((TextUtils.isDigitsOnly(product.getPortOnline()) && TextUtils.isDigitsOnly(product.getPortWol())) && (!product.getPortOnline().isEmpty() && !product.getPortWol().isEmpty()))  {
                    new Connection(activity, images.get(i), product.getIpOnline(), Integer.parseInt(product.getPortOnline()), product.getIpWol(), Integer.parseInt(product.getPortWol()), product.getMacAddress(), new Connection.AsyncResponse() {
                        @Override
                        public void processFinish(Boolean output) {
                        }
                    }).execute();
                }
            }
        }
    }