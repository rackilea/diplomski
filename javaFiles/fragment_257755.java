import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.xnap.commons.i18n.I18nFactory;

/**
* Injectable version of {@link org.xnap.commons.i18n.I18n}.
*
* @author Falko Menge
* @author nico.rehwaldt
*/
@Named("i18n")
@SessionScoped
public class I18n implements Serializable {

  private static final long serialVersionUID = 1L;
  private transient org.xnap.commons.i18n.I18n i18n;

  public org.xnap.commons.i18n.I18n getI18n() {
if (i18n == null) {
  FacesContext context = FacesContext.getCurrentInstance();
  String messageBundleName = context.getApplication().getMessageBundle();
  Locale locale = context.getViewRoot().getLocale();
  setI18n(I18nFactory.getI18n(getClass(), messageBundleName, locale, I18nFactory.FALLBACK));
}
return i18n;
  }

  public void setI18n(org.xnap.commons.i18n.I18n i18n) {
this.i18n = i18n;
  }

  public String marktr(String text) {
return org.xnap.commons.i18n.I18n.marktr(text);
  }

  public String tr(String text, Object o1, Object o2, Object o3, Object o4) {
return getI18n().tr(text, o1, o2, o3, o4);
  }

  public String tr(String text, Object o1, Object o2, Object o3) {
return getI18n().tr(text, o1, o2, o3);
  }

  public String tr(String text, Object o1, Object o2) {
return getI18n().tr(text, o1, o2);
  }

  public String tr(String text, Object o1) {
if (o1 instanceof Object[]) {
  return getI18n().tr(text, (Object[]) o1);
}
return getI18n().tr(text, o1);
  }

  public String tr(String arg0) {
return getI18n().tr(arg0);
  }

  public String trc(String arg0, String arg1) {
return getI18n().trc(arg0, arg1);
  }

  public String trn(String text, String pluralText, long n, Object o1, Object o2, Object o3, Object o4) {
return getI18n().trn(text, pluralText, n, o1, o2, o3, o4);
  }

  public String trn(String text, String pluralText, long n, Object o1, Object o2, Object o3) {
return getI18n().trn(text, pluralText, n, o1, o2, o3);
  }

  public String trn(String text, String pluralText, long n, Object o1, Object o2) {
return getI18n().trn(text, pluralText, n, o1, o2);
  }

  public String trn(String text, String pluralText, long n, Object o1) {
if (o1 instanceof Object[]) {
  return getI18n().trn(text, pluralText, n, (Object[]) o1);
}
return getI18n().trn(text, pluralText, n, o1);
  }

  public String trn(String arg0, String arg1, long arg2) {
return getI18n().trn(arg0, arg1, arg2);
  }

  public String trnc(String comment, String singularText, String pluralText, long n, Object obj1, Object obj2, Object obj3, Object obj4) {
return getI18n().trnc(comment, singularText, pluralText, n, obj1, obj2, obj3, obj4);
  }

  public String trnc(String comment, String singularText, String pluralText, long n, Object obj1, Object obj2, Object obj3) {
return getI18n().trnc(comment, singularText, pluralText, n, obj1, obj2, obj3);
  }

  public String trnc(String comment, String singularText, String pluralText, long n, Object obj1, Object obj2) {
return getI18n().trnc(comment, singularText, pluralText, n, obj1, obj2);
  }

  public String trnc(String comment, String singularText, String pluralText, long n, Object obj) {
if (obj instanceof Object[]) {
  return getI18n().trnc(comment, singularText, pluralText, n, (Object[]) obj);
}
return getI18n().trnc(comment, singularText, pluralText, n, obj);
  }

  public String trnc(String arg0, String arg1, String arg2, long arg3) {
return getI18n().trnc(arg0, arg1, arg2, arg3);
  }
}