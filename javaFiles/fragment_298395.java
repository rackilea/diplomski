package de.scrum_master.stackoverflow;

import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import org.codehaus.groovy.runtime.callsite.CallSite;

public class BrumbaApp implements GroovyObject {
  public BrumbaApp() {
    CallSite[] var1 = $getCallSiteArray();
    MetaClass var2 = this.$getStaticMetaClass();
    this.metaClass = var2;
  }

  public static void main(String... args) {
    CallSite[] var1 = $getCallSiteArray();
    var1[0].callConstructor(Brumba.class);
  }
}