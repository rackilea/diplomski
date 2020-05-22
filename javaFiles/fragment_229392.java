besoins.stream().forEach(besoin -> {
    String purchaseOrderPosition = besoin.getReferenceOa().trim();
    if(!purchaseOrderPosition.isEmpty()) {
        ValeursDynamiques valeursDynamiques = valeursDynamiquesService.DynamicValues(supplierNumber, purchaseOrderPosition);
        besoin.setQuantityInTransit(valeursDynamiques.getUsedValues().getQteEnTransit());
        besoin.setQuantityOrdered(valeursDynamiques.getUsedValues().getQteCommandee());
        besoin.setQuantityDelivered(valeursDynamiques.getUsedValues().getQteRecue());
        besoin.setDeliveryDateScheduled(valeursDynamiques.getUsedValues().getDateLivraisonPlanifiee());
        besoin.setDeliverydateConfirmed(valeursDynamiques.getUsedValues().getDateLivraisonConfirmee());
        besoin.setQuantityRestExpedited(valeursDynamiques.getUsedValues().getSoldeAExpedier());
    }   
}