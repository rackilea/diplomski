package com.mcpplc.supportclient.webapp.managedBeans;


import javax.faces.bean.*;
import java.io.Serializable;

@ManagedBean (name = "viewController")
@SessionScoped
public class ViewController implements Serializable
{
    String destinationPage = "splash";
    String transactionID;


    public String getDestinationPage()
    {
        return destinationPage;
    }

    public void setDestinationPage( String destinationPage )
    {
        this.destinationPage = destinationPage;
        transactionID = destinationPage.toUpperCase();
    }

    public String getTransactionID()
    {
        return transactionID;
    }

    public void setTransactionID( String transactionID )
    {
        this.transactionID = transactionID;
    }
}