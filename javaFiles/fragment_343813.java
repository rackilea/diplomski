public void reset(ActionMapping mapping, HttpServletRequest request) {
    if(multiboxField == null) {
        multiboxField = new String[2];
        multiboxField[0] = "optionOne";
        multiboxField[1] = "optionTwo";
    }
}