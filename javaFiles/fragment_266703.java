/*Add Click Listener*/
adapter.setOnRecyclerViewClickedListener(new Adapter.OnRecyclerViewItemClickedListener() {

    @Override
    public void OnRecyclerViewItemClicked(int position)  {
        try {
            JSONObject currTable = filteredTableList.getJSONObject(position);

            if (currTable.has("selected")) {
                currTable.put("selected", !currTable.getBoolean("selected"));
            } else {
                currTable.put("selected",true);
            }

            adapter.notifyItemChanged(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try
        {
            Toast.makeText(TableActivity.this, filteredTableList.getJSONObject(position).getString("tischnr"), Toast.LENGTH_SHORT).show();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void OnRecyclerViewItemBind(Adapter.ViewHolder holder, int position) {
        try {
            JSONObject currTable = filteredTableList.getJSONObject(position);

            holder.txt_no_table.setText(currTable.getString("tischnr"));

            int queasy33Index = ProgramMethod.getJSONArrayIndex(queasy33List,"number2", currTable.getInt("tischnr"));

            if (queasy33Index >= 0) {
                holder.txt_no_table.setText(holder.txt_no_table.getText() + "-" +  queasy33List.getJSONObject(queasy33Index).getString("key"));
            }

            if (currTable.has("selected") && currTable.getBoolean("selected")) {
                holder.itemView.setBackgroundResource(R.color.colorRedTableOcc);
            } else {
                holder.itemView.setBackgroundResource(R.color.colorTableGreen);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }