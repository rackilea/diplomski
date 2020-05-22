/** Warning codes. */
public enum Warning
{
    /** Password expiration warning.*/
    timeBeforeExpiration,
    /** Grace logins warning.*/
    graceAuthNsRemaining,
    none;
}

/** Error codes. */
public enum Error
{
    /** The password has expired.*/
    passwordExpired,
    /**
     * The account has been locked, either by an administrator
     * or as a result of too many failed login attempts.
     */
    accountLocked,
    /**
     * The password has been reset by an administrator and must be changed immediately.
     */
    changeAfterReset,
    /**
     * The password policy does not permit the user to change his password.
     */
    passwordModNotAllowed,
    /**
     * The password policy requires the old password to be supplied
     * when changing passwords.
     * This indicates a programming error in the client.
     */
    mustSupplyOldPassword,
    /**
     * The new password has failed the quality check.
     */
    insufficientPasswordQuality,
    /**
     * The new password is too short.
     */
    passwordTooShort,
    /**
     * The current password is too new to change yet.
     */
    passwordTooYoung,
    /**
     * The password policy specifies keeping a password history
     * and the new password is already in it.
     */
    passwordInHistory,
    /**
     * Error parsing the response control.
     * This indicates a programming error either in this
     * class or in the LDAP server.
     */
    unparseableResponseControl,
    /**
     * No additional information.
     * This can be seen e.g. when the user simply logs
     * in with the wrong password.
     */
    none;
};