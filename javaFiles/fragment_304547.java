@Override
public void onResponse(JSONObject response) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            JSONArray jsonNetworks = response.optJSONArray("networks");
            int len = jsonNetworks.length();
            for (int i = 0; i < len; i++) {
                JSONObject jsonNetwork = jsonNetworks.optJSONObject(i);
                Network network = new Network(jsonNetwork.optString("external_id"),
                        jsonNetwork.optString("name");

                networkItems.add(network);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    listAdapter.notifyDataSetChanged();
                }
            });
        }
    }).start();
}