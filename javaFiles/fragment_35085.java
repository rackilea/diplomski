public <E> SelectItem[] criarFiltrogenerico(E[] tp) {
        SelectItem[] options = new SelectItem[tp.length]; 
        for(int i = 0; i < tp.length; i++) {  
            options[i] = new SelectItem(tp[i].getId(),tp[i].getDescricao());  
        }  
        return options;
}