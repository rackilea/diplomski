@Override
public void save()
{       
    Date validFrom = new DateTime(DateTimeZone.forID("Europe/Vienna")).toDate();
    getEntity().setValidFrom(validFrom);

    currentValidityPeriod.setValidThru(validFrom);

    pointsValidityService.save(getEntity());

    addSavedSuccessfullyMessage();
}