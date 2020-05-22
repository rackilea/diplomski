private String Convert2Time(int Number) {
        int Hours, Minutes, HrsRemainder, MinRemainder, Seconds;
        Hours = Number / 3600;
        HrsRemainder = Number % 3600;
        Minutes = HrsRemainder / 60;
        Seconds = HrsRemainder % 60;

        StringBuilder result = new StringBuilder();
        if (Hours > 0) {
            result.append(Hours).append(" Hra ");
        } 
        if (Minutes > 0) {
            result.append(Minutes).append(" Min ");
        }

        result.append(Seconds).append( " Min ");

        return result.toString();
    }