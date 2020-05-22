package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.User;
import de.scrum_master.app.UserDB;
import de.scrum_master.app.UserDB.Action;
import de.scrum_master.app.UserDB.Error;
import de.scrum_master.app.UserDB.UserDBException;

@Aspect
public class UserActionLogger {
    @Around("execution(void de.scrum_master.app.UserDB.login(*)) && args(user)")
    public void captureLogin(ProceedingJoinPoint thisJoinPoint, User user) throws Throwable {
        try {
            thisJoinPoint.proceed();
            System.out.printf("%s|%s|%d03|%s%n",
                user.getId(), Action.login, Error.successful_login.ordinal(),
                "Successful " + UserDB.getRole(user) + " login"
            );
        } catch (UserDBException e) {
            System.out.printf("%s|%s|%03d|%s%n",
                e.userId, e.action, e.error.ordinal(),
                e.getMessage()
            );
            throw e;
        }
    }
}