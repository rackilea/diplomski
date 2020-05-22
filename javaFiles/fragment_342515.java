for (int k = 0; k < medias.length(); k += 1) {
    JSONObject mediaObject = (JSONObject) medias.opt(k);
    if (mediaObject.optString("gUid").equals(obj.optString("guid"))) {
        mediaObject.put("state", obj.optString("state"));
        mediaObject.put("id", obj.optString("mediaId"));
        mediaObject.put("path", obj.optString("path"));
        if (getActivity() != null) {
         getActivity().runOnUiThread(new Runnable() {
         @Override
         public void run() {
         if (adapter != null) {
         // I'm on my Fragment so I call my adapter like this , If you want to do this on your adapter , just call notifyDataSetChanged();
         adapter.notifyDataSetChanged();
         }
       }
      });
     }
    break;
   }
  }