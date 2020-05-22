mForecastAdapter = new ArrayAdapter<String>(
                //The current context (current activity)
                getActivity(),
                //ID of list item layout
                R.layout.list_item_forecast,
                //id of the textView to populate
                R.id.list_item_forecast_textview,
                //data to populate
                weekForecast
        );
//move this after the initialization of adapter
listView.setAdapter(mForecastAdapter);