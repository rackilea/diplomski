private static final List<Integer> AUMENTAR_RESOURCES = ImmutableList.of(
    R.id.botao_aumentar,
    R.id.botao_aumentar2,
    R.id.botao_aumentar3,
    ...
);

private final View.OnClickListener aumentarListener =
    new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int index =
                AUMENTAR_RESOURCES.indexOf(view.getId());
            valorExibido[index]++;
            String textoExibido = "" + valorExibido[index];
            buttonsExibir.get(index).setText(textoExibido);
        }
    };

private void hookupButtons() {
    for (index = 0; index < AUMENTAR_RESOURCES.size(); index++) {
        buttonsAumentar.get(index)
            .setOnClickListener(aumentarListener);
    }
}