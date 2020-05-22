novo_Vagao.vagaoAnterior = null;
novo_Vagao.vagaoPosterior = null;
if (head == null){
    head = tail = novo_Vagao;
} else {
    novo_Vagao.vagaoAnterior = tail;
    tail.vagaoPosterior = novo_Vago;
    tail = novo_Vagao;
}