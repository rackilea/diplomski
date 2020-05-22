public static PresentationBean addavailable2(final PresentationBean adBean, final LectureBean lecturerBean) {

        AvailabilityBean available = new AvailabilityBean();

        String availableID = adBean.getPresentationID();
        String availableDay = adBean.getPresentationDay();
        String lecturerID = lecturerBean.getLecturerID();
        String availID = available.getAvailableID();
        .......