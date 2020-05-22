package com.mcpplc.supportclient.webapp.managedBeans;

import com.mcpplc.supportclient.webapp.Utils.JSFUtils;
import com.mcpplc.supportclient.webapp.valueObjects.*;

import java.io.Serializable;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Mfa02BackingBean implements Serializable
{
    @ManagedProperty(value = "#{viewController}")
    private ViewController viewController;


    private Mfa02FormVO mfa02FormVO;    

    @PostConstruct
    public void init()
    {
       mfa02FormVO = (Mfa02FormVO) JSFUtils.getObjectFromRequest(Mfa02FormVO.class.getName());

    }

    public String doMFA02()
    {
        viewController.setDestinationPage("mfa01");
        return "viewController";
    }


     public void validateData ( FacesContext facesContext, UIComponent uiComponentToValidate, Object value)
    {
        String message = "";
        String requestData = (String) value;
        if ( !requestData.contains( "0" )  )
            {
                ((UIInput )uiComponentToValidate).setValid( false );
                message = "Incorrect format for Unit ID";
                facesContext.addMessage( uiComponentToValidate.getClientId(facesContext), new FacesMessage(message) );
                //JSFUtils.addObjectToRequest(Mfa02FormVO.class.getName(), mfa02FormVO);

            }



    }

.....getters&setters
}