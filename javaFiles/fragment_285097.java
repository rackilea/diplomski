callAppointments
        .flatMapIterable(appointments -> appointments)
        .flatMap(app -> Observable.zip(
             app, 
             patientServiceRx.getService().getPatientById(app.patient_id),
             servicesRestRx.getService().getSubserviceById(app.subservice_id),
             (app, patient, subservice) -> this.createListItem(app, patient, subservice))
         .toList()
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(list -> {/*set adapter*/}, error -> {/* handle error */});