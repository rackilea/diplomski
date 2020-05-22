KTable<String, String> s_table = builder.stream("s-order-topic",  Consumed.with(Serdes.String(),Serdes.String()))
                .mapValues(value -> {
                    String time;
                    JSONObject json = new JSONObject(value);
                    if (json.getString("op_type").equals("I")) {
                        time = "after";
                    }else {
                        time = "before";
                    }
                    JSONObject json2 = new JSONObject(json.getJSONObject(time).toString());
                    return json2.toString();
                })
                .groupBy((key, value) -> {
                    JSONObject json = new JSONObject(value);
                    return String.valueOf(json.getLong("ID"));
                }, Grouped.with(Serdes.String(), Serdes.String()))
                .reduce((prev,newval)->newval);