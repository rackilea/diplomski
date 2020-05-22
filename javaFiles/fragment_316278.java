JSONObject jsonObject = new JSONObject(respons); //Here reponse is the yours server response
JSONObject result = jsonObject.getJSONObject("result");
JSONArray sehedule = result.getJSONArray("sehedule");

for(int i=0;i<sehedule.length();i++)
{

    String schedule_id = sehedule.getJSONObject(i).getString("schedule_id");
    String schedule_date = sehedule.getJSONObject(i).getString("schedule_date");
    String schedule_name = sehedule.getJSONObject(i).getString("schedule_name");

  Toast.makeText(context,schedule_date+"    "+schedule_date+"   "+schedule_name,Toast.LENGTH_LONG).show();
}