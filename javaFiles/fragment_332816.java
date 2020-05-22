public class L10nService {
    ResourceBundle R = .... // initialize or change at runtime

    private List<LabelSetter> setters = new ArrayList<LabelSetter>();

    public void addSetter(LabelSetter setter) {
        setters.add(setter);
    }

    public void changeLanguage(Locale l) {
        R = ResourceBundle.getBundle("l10n/lang", l);
        for(LabelSetter s : setters) {
             s.set(R);
        }
    }
}