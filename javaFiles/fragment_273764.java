for (SolicitationDatabase solData : my) {
     solData.setStatus(data.get(1));
     if (data.size() > 2 && data.get(2) != null) { //this makes it crash
         solData.setReply(data.get(2));
     }
}