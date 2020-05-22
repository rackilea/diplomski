package com.mycompany.management.wildfly.extension;

import com.mycompany.management.facade.account.MyCompanyAccountFacade;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Default interceptor does not require @Interceptor
 * @author marembo
 */
public class MyCompanyInvocationContextReceiver {

    private static final Logger LOG = Logger.getLogger(MyCompanyInvocationContextReceiver.class.getName());

    @Resource
    private EJBContext ejbContext;
    @EJB
    private MyCompanyInvocationContext mycompanyInvocationContext;
    @EJB
    private MyCompanyAccountFacade mycompanyAccountFacade;

    @AroundInvoke
    public Object setMyCompanyAccount(final InvocationContext invocationContext) throws Exception {
        final Map<String, Object> contextData = ejbContext.getContextData();
        LOG.log(Level.INFO, "EJBContext data: {0}", contextData);
        LOG.log(Level.INFO, "InvocationContext data: {0}", invocationContext.getContextData());

        return invocationContext.proceed();
    }
}