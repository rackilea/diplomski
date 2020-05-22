public class SpecialDateEvaluator implements IDateEvaluator {

    private final List<Date> specialDates;

    public SpecialDateEvaluator(List<Date> specialDates) {
        this.specialDates = specialDates;
    }

    @Override
    public boolean isSpecial(Date date) {
        for (Date d : specialDates) {
            if (d.equals(date)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Color getSpecialForegroundColor() {
        return Color.black;
    }

    @Override
    public Color getSpecialBackroundColor() {
        return Color.red;
    }

    @Override
    public String getSpecialTooltip() {
        return null;
    }

    @Override
    public boolean isInvalid(Date date) {
        return false;
    }

    @Override
    public Color getInvalidForegroundColor() {
        return null;
    }

    @Override
    public Color getInvalidBackroundColor() {
        return null;
    }

    @Override
    public String getInvalidTooltip() {
        return null;
    }
}