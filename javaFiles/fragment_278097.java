package com.edfx.adb.scheduling;

import org.quartz.impl.JobDetailImpl;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

public class ADBJobDetailFactoryBean extends JobDetailFactoryBean {

    private boolean requestsRecovery;

    public ADBJobDetailFactoryBean() {
        super();
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        JobDetailImpl jobDetail = (JobDetailImpl) getObject();
        jobDetail.setRequestsRecovery(isRequestsRecovery());
    }

    public boolean isRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(boolean requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }
}