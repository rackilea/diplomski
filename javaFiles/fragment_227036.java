JSONObject jsonData = new JSONOnject("result");
                    JSONArray arr =  jsonData.getJSONArray("message");
                    for (int i=0; i < arr.length(); i++) {
                        JSONObject  json_data = arr.getJSONObject(i);

                    pedidos_nome.add((json_data.getString("pedidos_nome")));
                    pedidos_id.add((json_data.getString("pedidos_id")));
                    pedidos_email.add((json_data.getString("pedidos_email")));

                    }