public List<PraktykaInfo> getPracticeOfStudent(Long nrAlbumu) {
    List<PraktykiEntity> list = ipraktykiDAO.getPracticeOfStudent(nrAlbumu);
    List<PraktykaInfo> info = new ArrayList<PraktykaInfo>();
    //System.out.println(list.size());
    for(int i = 0; i<list.size(); i++) {
        PraktykiEntity practice = ipraktykiDAO.getRow(list.get(i).getIdPraktykiStudenckiej());
        if(practice !=null) {
            PraktykaInfo pi = new PraktykaInfo();
            pi.setIdPraktykiStudenckiej(practice.getIdPraktykiStudenckiej());
            pi.setSzablonPraktyki(iszablonyPraktykDAO.getTemplate(practice.getIdSzablonu()));
            pi.setPraktykodawca(ipraktykodawcyDAO.findEmployer(practice.getIdPraktykodawcy()));
            pi.setStatusPraktyki(istatusyDAO.getStatus(practice.getIdStatusu()));
            pi.setKierunek(ikierunkiStudiowDAO.getCourseInfo(practice.getIdKierunku()));
            pi.setTypPraktyki(itypyPraktykDAO.getTypeOfTraineeship(practice.getIdTypuPraktyki()));
            pi.setRokAkademicki(ilataAkademickieDAO.getYearOfCourse(practice.getIdRokuAkademickiego()));
            if(practice.getNrAlbumu() !=null) {
                pi.setStudent(istudenciDAO.getStudentInfo(practice.getNrAlbumu()));
            }
            pi.setOpiekunPraktyki(iopiekunowiePraktykDAO.getTutorInfo(practice.getIdOpiekunaPraktyk()));
            pi.setKoordynatorPraktyki(ikoordynatorzyPraktykDAO.getCoordinatorInfo(practice.getIdKoordynatoraPraktyk()));
            pi.setAdresPracodawcy(iadresyDAO.findByIdAdresu(practice.getIdAdresu()));
            if(practice.getIdPorozumienia() !=null) {
                pi.setPorozumienie(iporozumieniaDAO.getAgreement(practice.getIdPorozumienia()));
            }
            info.add(pi);
        } else {
            return null;
        }
    }
    return info;
}