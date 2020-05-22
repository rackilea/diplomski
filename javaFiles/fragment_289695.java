***
        Properties properties = new Properties();
        properties.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
        properties.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
        properties.put("ORBInitRef.NameService", settings.getIorString());

        // Connect to name service
        ORB orb = ORB.init((String[]) null, properties);
        POA poa = POAHelper.narrow(orb.resolve_initial_references(settings.getRootPoaName()));
        poa.the_POAManager().activate();
        logger.info("ORB init success");

        org.omg.CORBA.Object obj = orb.string_to_object(settings.getIorString());

        String epirpVersion = null;
        String systemDn = null;
        String irpId = null;
        String irpClassName = null;
        EPIRP epirp = EPIRPHelper.narrow(obj);
        String[] epirpVersions = epirp.get_EP_IRP_versions();
        for (String str : epirpVersions) {
            if (null != str && !"".equals(str.trim())) {
                epirpVersion = str;
            }
        }

        SupportedIRPListTypeHolder supportedIrpList = new SupportedIRPListTypeHolder();
        if (ResultType._OK == epirp.get_IRP_outline("", supportedIrpList).value()) {
            SupportedIRPListTypeElement[] typeHolder = supportedIrpList.value;
            for (SupportedIRPListTypeElement irpListEle : typeHolder) {
                systemDn = irpListEle.systemDN;

                logger.info("dnType:    " + systemDn);
                for (IRPElement irpElement : irpListEle.irpList) {
                    irpId = irpElement.irpId;
                    logger.info("irpId: " + irpId);
                    irpClassName = irpElement.irpClassName;
                    logger.info("irpClassName: " + irpClassName);
                    logger.info("irpVersion: " + irpElement.irpVersion);
                    logger.info("irpManagementScope: ");
                    for (String s : irpElement.irpManagementScope.value()) {
                        logger.info(s);
                    }
                }
            }
        } else {
            logger.error("Failed");
        }

        StringHolder alarmIrpIOR = new StringHolder();
        epirp.get_IRP_reference(managerIdentifier, systemDn, irpId, irpClassName, alarmIrpIOR);
        logger.info("AlarmIRP:" + alarmIrpIOR.value);

        //Connect to AlarmIRP
        AlarmIRP alarmIRP = AlarmIRPHelper.narrow(orb.string_to_object(alarmIrpIOR.value));