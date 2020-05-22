@Override
public void onClick(View view) {
    switch (view.getId()){
        case R.id.search_btn:
            responseText.setText("");
            String isNum = textNum.getText().toString();

            // create an instance of SharedPreferences
            SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
            String value = pref.getString("cardata", "");
            Type type = new TypeToken<ArrayList<Car>>() {}.getType()
            Gson gson = new Gson();
            ArrayList<Car> cars = gson.fromJson(value, type);

            // linear search
            boolean flag = false;
            for (Car car : cars) {
                if(car.num.equals(isNum)){
                    flag = true;
                    break;
                }
            }

            // not found. add new car
            if(!flag){
                cars.add(new Car(textCar.getText().toString(), textNum.getText().toString()));
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("cardata", gson.toJson(cars));
                editor.apply();
            }
     }
}