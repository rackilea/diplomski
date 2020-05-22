class ExtendedPeriod extends Period {
    int thirdPart;

    ExtendedPeriod(String periode) {
        String[] periodeSplit = periode.split("-");
        this.firstYear = Integer.parseInt(periodeSplit[0]);
        this.secondYear = Integer.parseInt(periodeSplit[1]);
        this.thirdPart = Integer.parseInt(periodeSplit[1]);
    }

    public String toString() {
        return "Day: " + this.firstYear + "\n" + "Month: " + this.secondYear
                + "\nYear: " + this.thirdPart;
    }
}