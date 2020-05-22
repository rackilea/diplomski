int [][]data = new int[numberOfDays][8];
 String url = "http://api.worldweatheronline.com/free/v2/weather.ashx?q=" + city + "&format=json&num_of_days=" + numberOfDays + "&cc=no&fx24=no&show_comments=no&tp=3&key=e74975c820b1f6506bd6b9fdea5a5";
 JSONObject dataZNetu;
 JSONArray dataArray;
 JSONObject dataHourly;
 JSONArray dataHourlyArray;
    try
    {
      WebContext webContext = new WebContext();
      dataZNetu = webContext.DownloadJSON(url).getJSONObject("data");
      dataArray = dataZNetu.getJSONArray("weather");
      for(int i = 0; i<dataArray.length(); i++)
      {
        dataHourly = dataArray.getJSONObject(i);
        dataHourlyArray = dataHourly.getJSONArray("hourly");
        for(int j = 0; j<dataHourlyArray.length(); j++){
          data[i][j] = dataHourlyArray.getJSONObject(j).getInt("FeelsLikeC");
          //temperatures[i*j] = new DataPoint(i*j,data[i*j]);
          Log.v("dataCorrect" + i,String.valueOf(data[i][j])); //Correct values
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    for(int i = 0;i<data.length;i++)
    {
      Log.v("dataBroken" + i/8,String.valueOf(data[i])); //Broken values
    }