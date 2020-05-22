package com.mycompany.view.service.wildfly.invocationcontext;

import com.mycompany.ejb.internal.MyCompanyAccount;
import com.mycompany.view.service.account.LoggedInAccount;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.jboss.ejb.client.AttachmentKey;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.EJBClientInterceptor;
import org.jboss.ejb.client.EJBClientInvocationContext;

import static com.mycompany.management.wildfly.invocationcontext.MyCompanyInvocationContextKey.MYCOMPANY_ACCOUNT_NUMBER;

/**
 * Registers itself as a jboss client interceptor.
 * @author marembo
 */
@Singleton
@Startup
public class MyCompanyInvocationContextInterceptor implements EJBClientInterceptor {

    private static final Logger LOG = Logger.getLogger(MyCompanyInvocationContextInterceptor.class.getName());
    private static final AttachmentKey<Long> MYCOMPANY_ACCOUNT_NUMBER_KEY = new AttachmentKey<>();

    @Inject
    @LoggedInAccount
    private Instance<MyCompanyAccount> loggedInAccount;

    @PostConstruct
    void registerSelf() {
        EJBClientContext.requireCurrent().registerInterceptor(0, this);
    }

    @Override
    public void handleInvocation(final EJBClientInvocationContext ejbcic) throws Exception {
        LOG.log(Level.INFO, "Intercepting invocation on: {0}", ejbcic.getInvokedMethod());

        final EJBClientContext clientContext = ejbcic.getClientContext();
        if (!loggedInAccount.isUnsatisfied()) {
            final MyCompanyAccount mycompanyAccount = loggedInAccount.get();
            if (mycompanyAccount != null) {
                final Long accountNumber = mycompanyAccount.getAccountNumber();
                clientContext.putAttachment(MYCOMPANY_ACCOUNT_NUMBER_KEY, accountNumber);
            }
        }
        ejbcic.getContextData().put(MYCOMPANY_ACCOUNT_NUMBER, "348347878483");

        ejbcic.sendRequest();
    }

    @Override
    public Object handleInvocationResult(final EJBClientInvocationContext ejbcic) throws Exception {
        return ejbcic.getResult();
    }

}