Gson gson = new Gson();
GsonClass gsonClass = gson.fromJson(response,GsonClass.class);

String UserID = gsonClass.getUserID();

for (int i = 0; i < gsonClass.getData1().getData1_1().size(); i++) {
    String name = gsonClass.getData1().getData1_1().get(i).getName();
    String test = gsonClass.getData1().getData1_1().get(i).getTest();
}

for (int i = 0; i < gsonClass.getData1().getData1_2().getData1_2_1().size(); i++) {
    String addr = gsonClass.getData1().getData1_2().getData1_2_1().get(i).getAddr();
    String phone = gsonClass.getData1().getData1_2().getData1_2_1().get(i).getPhone();
}

for (int i = 0; i < gsonClass.getData1().getData1_2().getData1_2_2().size(); i++) {
    String country = gsonClass.getData1().getData1_2().getData1_2_2().get(i).getCountry();
    String sex = gsonClass.getData1().getData1_2().getData1_2_2().get(i).getSex();
}