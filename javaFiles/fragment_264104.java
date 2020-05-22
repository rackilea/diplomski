MediCareSupplier mediCare = new MediCareSupplier();
    MediCareSupplierSoap mediCareSOAP = mediCare.getMediCareSupplierSoap();

    Holder<Boolean> getSupplierByZipCodeResult = new Holder<Boolean>();
    Holder<SupplierDataList> supplierDataLists = new Holder<SupplierDataList>();
    mediCareSOAP.getSupplierByZipCode(zip, getSupplierByZipCodeResult, supplierDataLists);

    List<SupplierData> supplierDataList = supplierDataLists.value.getSupplierDatas().getSupplierData();