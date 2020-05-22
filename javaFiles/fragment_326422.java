public Map<String, List<Documento>> indice = new HashMap<>();

//register new word
indice.putIfAbsent(palavra, new ArrayList<>());
//add additional occurence
indice.get(palavra).add(documento);
//get frequency
int frequencia = indice.get(palavra)
                       .stream()
                       .map(d -> d.getFrequencia())
                       .reduce(0, (s, i) -> s + i);