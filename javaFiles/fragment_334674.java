public void enviaDadosVenda(){
        JSONObject obj = new JSONObject();
        JSONArray avaliacoes = new JSONArray();
        JSONObject avaliacao;

        try {
            obj.put("id", 0);
            obj.put("ticket", "DemoActivity.ticket_id");

            for(int i=0; i < 2;i++){
                avaliacao = new JSONObject();
                avaliacao.put("idAvaliacao", "1");
                avaliacao.put("nota", "nota");
                avaliacao.put("observacao", "observacao");
                avaliacoes.put(avaliacao);

            }
            obj.put("avaliacoes", avaliacoes);
            Log.d("DEMO", obj.toString());  // {"id":0,"ticket":"DemoActivity.ticket_id","avaliacoes":[{"idAvaliacao":"1","nota":"nota","observacao":"observacao"},{"idAvaliacao":"1","nota":"nota","observacao":"observacao"}]}

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }