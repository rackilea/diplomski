String JSONString = "{" +
                "  \"retorno\": {" +
                "    \"empresas\": [" +
                "      {" +
                "        \"cnpj\": \"05.743.645/0001-38\"," +
                "        \"razao_social\": \"GISELA TRANSPORTES E DISTRIBUIDORA DE FLORES LTDA - ME\"," +
                "        \"endereco\": \"EST RSC-453 (ROTA DO SOL) KM 93,8\"," +
                "        \"bairro\": \"BAIRRO ALFANDEGA\"," +
                "        \"numero\": 26," +
                "        \"complemento\": \"\"," +
                "        \"telefone\": \"3462 2749\"," +
                "        \"celular\": \"\"," +
                "        \"email\": \"giselaflores@giselaflores.com.br\"" +
                "      }" +
                "    ]" +
                "  }" +
                "}";
        try {
            JSONObject jsonEmpresa = new JSONObject(JSONString);
            JSONObject retorno = jsonEmpresa.getJSONObject("retorno");
            JSONArray empresas = retorno.getJSONArray("empresas");
            JSONObject empresa =  empresas.getJSONObject(0);

            String email =empresa.getString("email");

        } catch (JSONException e) {
            e.printStackTrace();
        }