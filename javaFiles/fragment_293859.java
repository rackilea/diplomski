if (Optional.ofNullable(country)
            .map(Country::getCity)
            .map(City::getSchool)
            .map(School::getStudent)
            .isPresent()) {
    isValid = true;
}