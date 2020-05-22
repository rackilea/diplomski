if(en.getEnrollmentStatusTracks() != null)
            {
            Set<EnrollmentStatusTrack> set= new HashSet<EnrollmentStatusTrack>();
            set=en.getEnrollmentStatusTracks();
            List<EnrollmentStatusTrack> list  = new ArrayList<EnrollmentStatusTrack>(set); 
            Collections.sort(list, Comparator.comparingInt(EnrollmentStatusTrack::getEnrollmentStatusTrackId)); 
            if(list.size() > 0)
            {
             ent=list.get(list.size() - 1);
            }
}