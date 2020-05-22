class BeanToBeInjected {
}

class BeanThatNeedsInjection {
    BeanToBeInjected beanToBeInjected;
    public void setBeanToBeInjected(BeanToBeInjected beanToBeInjected) {
        this.beanToBeInjected = beanToBeInjected;
    }
}

class BeanFactory {
    public Object createBean(String id) {
        if("beanThatNeedsInjection".equals(id) {
            BeanThatNeedsInjection beanThatNeedsInjection = new BeanThatNeedsInjection();
            beanThatNeedsInjection.setBeanToBeInjected(new BeanToBeInjected());
            return beanThatNeedsInjection;
        }
        return null;
    }
}

class MyService {
    public void service() {
        BeanThatNeedsInjection beanThatNeedsInjection =
            new BeanFactory().createBean("beanThatNeedsInjection");
    }
}