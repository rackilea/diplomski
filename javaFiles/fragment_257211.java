public class Period {

    int[] years;

    Period() {

    }

    Period(String periode) {

        String[] periodeSplit = periode.split("-");
        years = new int[periodeSplit.length];
        for (int i = 0; i < periodeSplit.length; i++) {
            years[i] = Integer.parseInt(periodeSplit[i]);
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < years.length; i++) {
            result += "Year " + i + ":" + years[i] + "\n";
        }
        return result;
    }
}