public class SetIdIdiomaToSetIdioma extends DozerConverter<Set, Set>{


public SetIdIdiomaToSetIdioma() {
    super(Set.class, Set.class);
}

@Override
public Set<Idioma> convertFrom(Set ids, Set idiomas) {
    if(ids != null && ids.size() > 0){
        idiomas = new HashSet<Idioma>();
        for (Object object : ids) {
            if(object.getClass().equals(Integer.class)){
                Integer id = (Integer) object;
                if(id != null){
                    Idioma idioma = new Idioma();
                    idioma.setIdIdioma(id);
                    idiomas.add(idioma);
                }
            }
        }
    }

    return idiomas;
}

@Override
public Set<Integer> convertTo(Set idiomas, Set ids) {
    if(idiomas != null && idiomas.size() > 0){
        ids = new HashSet<Integer>();
        for (Object object : idiomas) {
            Idioma idioma = (Idioma) object;
            if(idioma != null && idioma.getIdIdioma() != null)
                ids.add(idioma.getIdIdioma());
        }
    }
    return ids;
}


}