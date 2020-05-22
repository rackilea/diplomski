package de.scrum_master.app;

import java.lang.reflect.Method;

import de.scrum_master.aspect.TweakAuthenticationAspect;

public class UserAuthentication {
    private static final String USER_NAME_GOOD = "alexander"; // Add your own user name here
    private static final String USER_NAME_BAD = "hacker";

    public static boolean isCurrentUser(String userID) throws Exception {
        Class<?> ntSystemClass = Thread.currentThread().getContextClassLoader()
                .loadClass("com.sun.security.auth.module.NTSystem");
        Method getNameMethod = ntSystemClass.getMethod("getName");
        Object ntSystem = ntSystemClass.newInstance();
        String currentUserID = (String) getNameMethod.invoke(ntSystem);
        boolean same = userID.equalsIgnoreCase(currentUserID);
        if (same) {
            System.out.println("Do something (same == true)");
        } else {
            System.out.println("Do something (same == false)");
        }
        return same;
    }

    public static void main(String[] args) throws Exception {
        testAuthentication(false);
        testAuthentication(true);
    }

    private static void testAuthentication(boolean hackingMode) throws Exception {
        TweakAuthenticationAspect.hackingMode = hackingMode;
        System.out.println("Testing authentication for hackingMode == " + hackingMode);
        System.out.println("Authentication result for " + USER_NAME_GOOD + ": "
                + isCurrentUser(USER_NAME_GOOD));
        System.out.println("Authentication result for " + USER_NAME_BAD + ": "
                + isCurrentUser(USER_NAME_BAD));
        System.out.println();
    }
}