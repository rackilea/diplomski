public interface Dictionaries<T extends DictionaryModel> {
    Dictionaries<FirstDictionary>  FIRST_DICTIONARY  = () -> FirstDictionary.class;
    Dictionaries<SecondDictionary> SECOND_DICTIONARY = () -> SecondDictionary.class;

    Class<T> clazz();
}