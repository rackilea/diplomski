package com.uk.mysqlmaven.jsf.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.uk.mysqlmaven.util.Constants;
import com.uk.mysqlmaven.util.ResourceKeys;

public class RegistrationBean {

private String fathersOrGuardianName;

public String getFathersOrGuardianName() {
    return fathersOrGuardianName;
}

public void setFathersOrGuardianName(String fathersOrGuardianName) {
    this.fathersOrGuardianName = fathersOrGuardianName;
}

public String submitRegistrationAction() {
    if (validationRegistration()) {
        return "views/home.faces?faces-redirect=true&param=98";
    } else {
        return "";
    }
}

public Boolean validationRegistration() {
    if (this.fathersOrGuardianName.length() == 0) {
        String commonName = ResourceKeys.getInstance().get("lblPleaseEnter", Constants.Resources.BUNDLENAME_MYSQLMAVEN);
        String displayName = ResourceKeys.getInstance().get("lblFathersOrGuardianName", Constants.Resources.BUNDLENAME_MYSQLMAVEN);
        FacesContext.getCurrentInstance().addMessage(fathersOrGuardianName, new FacesMessage(FacesMessage.SEVERITY_ERROR, commonName +" "+ displayName , "Fathers/GurdianName can't be empty."));
    }
    return Boolean.FALSE;
}

public void clearRegistrationAction(ActionEvent event) {
    this.fathersOrGuardianName = "";
}

}