package com.examples;
public class RegistrationAction extends ActionSupport implements Preparable {

    @Override
    public void prepare() throws Exception {
        // get the data that you want to pre-populate
    }

    public String execute() {
        // you action logic
        return SUCCESS;
    }

}



<!-- Calls the params interceptor twice, allowing you to pre-load data for the second time parameters are set -->
<!-- don't forgot to add prepare interceptor to interceptor stack -->
 <action name="someAction" class="com.examples.RegistrationAction">
     <interceptor-ref name="params"/>
     <interceptor-ref name="prepare"/>
     <interceptor-ref name="basicStack"/>
     <result name="success">good_result.ftl</result>
 </action>