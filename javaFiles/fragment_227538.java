private static TRUSTEE createTrusteeForCurrentUser() {
    TRUSTEE result = new TRUSTEE();
    result.TrusteeForm = TRUSTEE_FORM.TRUSTEE_IS_NAME;
    result.TrusteeType = TRUSTEE_TYPE.TRUSTEE_IS_USER;
    result.ptstrName = new NativeString("CURRENT_USER",true).getPointer();
    result.write();
    return result;
}