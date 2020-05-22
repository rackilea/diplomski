List<CautionsDTO> cautions = new ArrayList<>(); 
    ContratExportation contrat = new ContratExportation();

    CautionDTO caution = new CautionDTO();
    cautions.add(caution);
    dataDelService.addCautions(cautions,contrat);