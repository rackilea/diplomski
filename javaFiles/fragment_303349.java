RequestFuture<String> future = RequestFuture.newFuture();
StringRequest request = new StringRequest(Request.Method.POST, URL_UPDATE, future, future){
    @Override
    protected Map<String,String> getParams(){
        Map<String,String> params = new HashMap<String, String>();
        params.put("consulta",consultaExterna);
        return params;
    }
};
RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
requestQueue.add(request);

try {
  String response = future.get(); 
  Log.d("Bien:",response.substring(0));
  correctoExterna = true;
} catch (InterruptedException | ExecutionException e) {
  correctoExterna = false;
}

if(correctoExterna) snackBar();