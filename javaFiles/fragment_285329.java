for (int i = 0; i < android.length(); i++) {
                JSONObject c = android.getJSONObject(i);
                // Storing each json item in variable
                String flag = c.getString("flag");
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("flag", flag);
                arraylist.add(i, map);

            }