public void setMobile(String mobile) {
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(mobile);
    if (m.matches()) {
        this.mobile = mobile;
    }
}