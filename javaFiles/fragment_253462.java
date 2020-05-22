getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            try {
                Glide.with(getActivity()).load(jsonObject.getString("dispensary_thumbmail")).into(image);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    });