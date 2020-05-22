new Callback() {


    @Override
    public void onFailure(Request request, IOException e) {
        getSummonerInfoFromId(SumName,participant);
    }

    @Override
    public void onResponse(Response response) throws IOException {


        try {
            String jsonData = response.body().string();



                JSONObject jsonObj = new JSONObject(jsonData);
                JSONObject game = jsonObj.getJSONObject(SumName.toLowerCase().replace(" ",""));

                String summonerLevel = Long.toString(game.getLong("summonerLevel"));


                participant.put("summonerLevel",summonerLevel);


        }
        catch (IOException e) {

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}