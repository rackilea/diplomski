public void setMobile(String mobile) {
    for (char ch : mobile.toCharArray()) {
        if (!Character.isDigit(ch)) {
            return;
        }
    }
    this.mobile = mobile;
}