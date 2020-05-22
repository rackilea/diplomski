@Override
    public int compareTo(Object object) {

    TimeZoneModel timezoneModel = null;

    Double val1 = 0d;
    Double val2 = 0d;

    if (object instanceof TimeZoneModel) {
        timezoneModel = (TimeZoneModel) object;

        String strVal = timezoneModel.getValue();

        if (strVal != null) {

            strVal = strVal.replace(":", ".");

            if (strVal.contains("-")) {

                val1 = Double.valueOf(strVal.replace("-", ""));
                val1 = val1 * -1;

            } else {
                val1 = Double.valueOf(strVal.replace("+", ""));
            }

        }

        String value = this.value.replace(":", ".");

        if (value.contains("-")) {

            val2 = Double.valueOf(value.replace("-", ""));
            val2 = val2 * -1;

        } else {
            val2 = Double.valueOf(value.replace("+", ""));
        }

    }

    return val2.compareTo(val1);
}