package com.xyz;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.IgnoreDependency;

@Stateless
public class BeanB  implements BeanBLocalInterface  {
    @IgnoreDependency
    @EJB(name="ejb/BeanALocalInterface ") private BeanALocalInterface localInterface;
    public BeanB() {  }
    public void executeLocal() { localInterface.executeLocal(); }
    public void executeRemote() { System.out.println("executing in  BeanB");}
}