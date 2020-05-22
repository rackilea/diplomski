repalce 
{"cityName":["'cityId':4',cityName: 'Ahmedabad'","'cityId':8',cityName: 'Pune'"]}
with
{"cityName":["'cityId':6,'cityName':'Baroda'","'cityId':7,'cityName':'Surat'"   ] }

replace

JSONObject jobjcity = citynamearray.getJSONObject(k);

with
JSONObject jobjcity = new JSONObject(citynamearray.getJSONString(k));