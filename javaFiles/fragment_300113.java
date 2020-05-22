import java.text.*
import java.util.*

ArrayList<Locale> locales = new ArrayList<Locale>();
locales.add(Locale.US);
locales.add(Locale.UK);
locales.add(Locale.GERMANY);
locales.add(Locale.CHINA);

Date date = new Date();

for(Locale l : locales)
{
    SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.SHORT, l);
    String pattern = sdf.toPattern();
    String localizedPattern = sdf.toLocalizedPattern()
    println "country: " + l.getDisplayName();
    println "pattern: " + pattern;
    println "localizedPattern: " + localizedPattern;

    try {
        SimpleDateFormat temp = new SimpleDateFormat(localizedPattern, l);
        println "localized pattern re-parsed successfully"
    } catch (IllegalArgumentException e) {
        println "localized pattern re-parsed unsuccessfully: " + e.getMessage();
    }
    SimpleDateFormat df = new SimpleDateFormat(pattern, l);
    String dateString = df.format(date);
    println "resulting date: " + dateString
    String yearlessPattern = pattern.replaceAll("\\W?[Yy]+\\W?", "");
    println "yearlessPattern = " + yearlessPattern;
    SimpleDateFormat yearlessSDF = new SimpleDateFormat(yearlessPattern, l);
    println "resulting date without year: " + yearlessSDF.format(date) + "\n";
}