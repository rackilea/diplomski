ActivitiesBean bean;
ArrayList<Object> listActivities = new ArrayList<Object>();

............................



 public class FetchActivitesTask extends AsyncTask<Void, Void, Void> {

    int i =0;
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
         pgb.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub

         ............

                    Here your JSON code

            for (i = 0; i < jsonnodes.length(); i++) 
            {


                JSONObject jsonnode = jsonnodes.getJSONObject(i); 

                JSONObject jsonnodevalue = jsonnode.getJSONObject(node);

                bean = new ActivitiesBean();

                bean.title = jsonnodevalue.getString(title);
                bean.image = jsonnodevalue.getString(image_fid);

                                    .....................  


                listActivities.add(bean);


            }               
        }
        catch (JSONException e) {

            e.printStackTrace();
      }

        return null;
    }

    @Override
    public void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);

        pgb.setVisibility(View.GONE);
        displayAdapter();
    }
}

public void displayAdapter()
{
    adapter = new ActivityAdapter(this, listActivities);
    contests_listView.setAdapter(adapter);
    contests_listView.setOnItemClickListener(new OnItemClickListener() {

        //@Override
        public void onItemClick(AdapterView<?> arg0, View arg1,
                int position, long id) {

            bean = (ActivitiesBean) adapter.getItem(position);

            Intent in1 = new Intent(Activites_Activity.this, Activity_display.class);
            in1.putExtra("ActivityObject", bean);
            startActivity(in1);
        }

    });

}