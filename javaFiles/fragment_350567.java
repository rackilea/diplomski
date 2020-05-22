package com.test.validation;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class FormValidators implements Serializable {

   private static final long serialVersionUID = 7157377379640149444L;

   public void validateEmail(FacesContext facesContext, UIComponent component, Object value) {
      // Check if email is valid or not
      if (value.toString().equals("") || value.toString().indexOf('@') == -1) {
         // Create a message -> email is invalid
         FacesMessage message = new FacesMessage("Email is invalid!");
         // Throw an exception so that it prevents document from being saved
         throw new ValidatorException(message);
      }
   }

}