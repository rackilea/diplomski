public void tratar_primer_ranking() {
    //Ranking extendido - cerrado
    RelativeLayout ranking_1_completo = (RelativeLayout) findViewById(R.id.ranking_1_completo);
    ranking_1_completo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RelativeLayout ocultar_layout_1_1 = (RelativeLayout) findViewById(R.id.ocultar_layout_1_1);
            RelativeLayout ocultar_layout_2_1 = (RelativeLayout) findViewById(R.id.ocultar_layout_2_1);
            LinearLayout ocultar_layout_4_1 = (LinearLayout) findViewById(R.id.ocultar_layout_4_1);
            if (!extendido_1) {
                ocultar_layout_1_1.setVisibility(View.GONE);
                ocultar_layout_2_1.setVisibility(View.VISIBLE);
                ocultar_layout_4_1.setVisibility(View.VISIBLE);
                extendido_1 = true;
            } else {
                ocultar_layout_1_1.setVisibility(View.VISIBLE);
                ocultar_layout_2_1.setVisibility(View.GONE);
                ocultar_layout_4_1.setVisibility(View.GONE);
                extendido_1 = false;
            }
        }
    });
}