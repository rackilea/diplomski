public Incident getIncidentByIDandDate(String incidentID, String date) {
//here comes the PK's class with the info I'm searching setted
                IncidentPK PK = new IncidentPK();
                PK.setIncidentID(incidentID);
                PK.setdate(date);

                Incident incident = em.find(Incident.class, PK);
                return incident;    
        } //if returns null means that no incident with this info's were found