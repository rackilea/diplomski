Gson gson = new Gson();
Map<String, ?> all = tinydb.getAll();
            Iterator       it  = all.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                LocalTrack localTrack = gson.fromJson(pairs.getValue().toString(), LocalTrack.class);
            }