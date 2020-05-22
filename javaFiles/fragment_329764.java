BooleanOrInt methodOfA() {
    if (some_condition) {
        return new BooleanOrInt(the_boolean_you_want);
    }
    else {
        return new BooleanOrInt(the_integer_you_want);
    }
}