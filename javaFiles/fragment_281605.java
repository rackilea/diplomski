<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<html:form action="/sendContactForm.do?ContactCd=sendContactForm"
        method="post" styleId="sendContactForm">
        <c:set var="sendContactForm" value="${sendContactForm}" />

        <html:errors />



        <label for="firstname">First Name <span class="asterisk">*</span>
        </label>
        <html:text styleId="firstname" property="firstname"
            styleClass="form-control tip required" name="sendContactForm" />



        <label for="lastname">Last Name <span class="asterisk">*</span>
        </label>
        <html:text styleId="lastname" property="lastname"
            styleClass="form-control tip pplaceholder" name="sendContactForm" />



        <label for="emailaddress">Email Address <span class="asterisk">*</span>
        </label>
        <html:text styleId="emailaddress" property="emailaddress"
            styleClass="form-control tip pplaceholder" name="sendContactForm" />


        <label for="subject">Subject <span class="asterisk">*</span>
        </label>
        <html:text styleId="subject" property="subject"
            styleClass="form-control tip pplaceholder" name="sendContactForm" />

        <label for="comments">Comments <span class="asterisk">*</span>
        </label>
        <html:textarea styleId="comments" property="comments"
            styleClass="form-control tip pplaceholder" name="sendContactForm"></html:textarea>

    </html:form>


</body>
</html>