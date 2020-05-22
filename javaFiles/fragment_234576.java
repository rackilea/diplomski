if (CommonUtility.checkValidate(firstName) || CommonUtility.checkValidate(lastName) ||
 CommonUtility.checkValidate(newUserName)) {
        response
        .sendRedirect(PHConstants.CONTEXT_PATH
            + "/login/registrationError.jsp");
        return;
        }


    public static boolean checkValidate(String name) {
        if (null != name) {
        String patternString = ".*javascript:.*|.*//.*|.*<.*|.*>.*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
        }
        return false;
    }