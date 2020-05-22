package com.xyz;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.IgnoreDependency;
@Stateless
public class BeanA implements  BeanALocalInterface {
    @IgnoreDependency
    @EJB(name="ejb/BeanBLocalInterface")    private BeanBLocalInterface beanBLocalInterface;
    public BeanA() {}
    public void executeLocal() {System.out.println("executing in  BeanA"); beanBLocalInterface.executeLocal();}
    public void executeRemote() {System.out.println("executing in  BeanA"); }
}