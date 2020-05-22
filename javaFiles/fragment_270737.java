if (vagao.vagaoPosterio == null) {
    tail = vagao.vagaoAnterior;
} else {
    vagao.vagaoPosterio.vagaoAnterio = vagao.vagaoAnterior;
}
...