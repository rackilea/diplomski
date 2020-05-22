package com.mcpplc.supportclient.webapp.managedBeans;

import com.mcpplc.supportclient.webapp.Utils.JSFUtils;
import com.mcpplc.supportclient.webapp.valueObjects.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Mfa01BackingBean
{
    @ManagedProperty(value = "#{viewController}")
    private ViewController viewController;

    private ImportConsignmentVO importConsignmentVO;
    private VoyageVO voyageVO;

    private Mfa01FormVO mfa01FormVO;

    private Mfa02FormVO mfa02FormVO;

    @PostConstruct
    public void init()
    {
        mfa01FormVO = new Mfa01FormVO();
    }

    public void doMFA01()
    {
        //pretend to get VOs
        importConsignmentVO = new ImportConsignmentVO();
        voyageVO = new VoyageVO();

        //set some VO stuff
        if ( mfa01FormVO.getUcn().equalsIgnoreCase( "123" ) )
        {
            importConsignmentVO.setUnitID("AJF1");
            voyageVO.setVesselName("Ever Glade");
        }
        else {
            importConsignmentVO.setUnitID("ZZZ1");
            voyageVO.setVesselName("Ever Champion");
        }
        importConsignmentVO.setType("41G1");
        importConsignmentVO.setWeight("25000");
        voyageVO.setEta("01/01/2011");

        constructMFA02Form();

        viewController.setDestinationPage("mfa02");

    }

    private void constructMFA02Form()
    {
        mfa02FormVO = new Mfa02FormVO();
        mfa02FormVO.setUnitID(importConsignmentVO.getUnitID());
        mfa02FormVO.setType(importConsignmentVO.getType());
        mfa02FormVO.setWeight(importConsignmentVO.getWeight());
        mfa02FormVO.setMfaRef("12345");
        mfa02FormVO.setVesselName(voyageVO.getVesselName());
        mfa02FormVO.setEta(voyageVO.getEta());

        JSFUtils.addObjectToRequest(Mfa02FormVO.class.getName(), mfa02FormVO);
    }

  .....getters&setters

}