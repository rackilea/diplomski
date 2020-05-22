@ManagedBean(name="langListing")
@ViewScoped
public class LangListing implements Serializable {
    private List<SelectItem> languages = new ArrayList<SelectItem>();
    private String language;

    public LangListing() {
       languages.add(new SelectItem("en", FacesUtil.getResourceBundle().getString("LANG_LABEL_01"))); // English
       languages.add(new SelectItem("fr", FacesUtil.getResourceBundle().getString("LANG_LABEL_02"))); // French
       language = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
    }   

    public List<SelectItem> getLanguages() { 
       return languages;
    }

    public String getLanguage() {
       return language;
    }

    public void setLanguages(List<SelectItem> languages) {
       this.languages = languages;
    }    

    public void setLanguage(String language) {
       this.language = language;
    }

    public void changeLocale(AjaxBehaviorEvent event) {
       FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
 }