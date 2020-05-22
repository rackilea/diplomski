uniChoiceBox.setConverter(new StringConverter<University>() {
    @Override
    public String toString(University uni) {
        return uni.getUniversityName();
    }
    @Override
    // not used...
    public University fromString(String s) {
        return null ;
    }
});