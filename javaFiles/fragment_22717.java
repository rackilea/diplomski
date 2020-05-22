if (!rs.next()) {
            req = " select jour.PJO_HORDEBPLAGE1,jour.PJO_HORFINPLAGE1,jour.PJO_HORDEBPLAGE2,jour.PJO_HORFINPLAGE2"
            + " from profilpressalarie propressal join profilpresence propres on propressal.ppz_profilpres = propres.ppq_profilpres "
            + "join modelecycle modcyc on propres.PPQ_CYCLEAFFECT = modcyc.PMO_MODELECYCLE join JOURNEETYPE jour " +
            " on modcyc.PMO_JOURNEETYPE= jour.PJO_JOURNEETYPE where modcyc.PMO_ORDREJOUR='"+orderJ+"' " +
            " and propressal.PPZ_salarie= '"+chaine+"'";
    }