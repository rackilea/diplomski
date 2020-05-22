private RadioGroup<Integer> criarCampoFrequencia( RegistroPresencaColaborador registroPreColaborador ) {
    final RadioGroup<Integer> radioGroupTipo = new RadioGroup<Integer>("frequencia", new PropertyModel<Integer>(registroPreColaborador, "frequencia")){
        private static final long serialVersionUID = 1L;
        @Override
        public boolean isEnabled() {
            if(getAbstractBean().getId()!=null && getAbstractBean().getVisualizar()){
                return false;

            }else{
                return true;
            }
        }
    };

}