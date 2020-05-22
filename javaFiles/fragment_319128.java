try {
            List<Route> routes=new ArrayList<Route>();

            JSONObject mainJSON=new JSONObject(jsonJ);
            JSONArray jarray1=mainJSON.getJSONArray("routes");
            JSONObject jobj1=jarray1.getJSONObject(0);
            JSONArray jarray2=jobj1.getJSONArray("legs");
            JSONObject jobj2=jarray2.getJSONObject(0);
            JSONArray stepArray=jobj2.getJSONArray("steps");

            for (int i=0;i<stepArray.length();i++){
                Route route=new Route();

                JSONObject jobj5=stepArray.getJSONObject(i);
                JSONObject disOBJ=jobj5.getJSONObject("distance");
                JSONObject durOBJ=jobj5.getJSONObject("duration");
                JSONObject endOBJ=jobj5.getJSONObject("end_location");
                JSONObject polOBJ=jobj5.getJSONObject("polyline");
                JSONObject startOBJ=jobj5.getJSONObject("start_location");

                route.startAddress=jobj2.getString("start_address");
                route.endAddress=jobj2.getString("end_address");

                if (jobj5.has("maneuver")){
                    route.maneuver=new Maneuver(jobj5.getString("maneuver"));
                }

                route.distance=new Distance(disOBJ.getString("text"),disOBJ.getString("value"));
                route.duration=new Duration(durOBJ.getString("text"),durOBJ.getString("value"));
                route.startLocation=new LatLng(startOBJ.getDouble("lat"),startOBJ.getDouble("lng"));
                route.endLocation=new LatLng(endOBJ.getDouble("lat"),endOBJ.getDouble("lng"));
                route.points=decodePoluLine(polOBJ.getString("points"));

                routes.add(route);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }