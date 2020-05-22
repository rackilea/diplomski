enum Industry {

    CREATOR("I")/*, here comes more values of the enum*/;

    private String code;

    Industry(String code) {
        this.code = code;
    }

    public static Industry forCode(String code) {

        return Arrays.stream(Industry.values())
                     .filter(industry -> industry.code.equals(code))
                     .findAny()
                     .orElse(null);
    }
}