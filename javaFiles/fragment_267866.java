for (Iterator<DrugStrength> it = aDrugStrengthList.iterator(); it.hasNext(); ) {
    DrugStrength aDrugStrength = it.next();
    if (!aDrugStrength.isValidDrugDescription()) {
        it.remove();
    }
}