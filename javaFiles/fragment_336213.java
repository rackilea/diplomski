public void setBookedArtist(Long workDayId, String artist){
            workDayRepository
                 .findById(workDayId)
                 .ifPresent(workDay -> workDayDetailsService.saveBookedArtist(workDay, artist));
        }

    void saveBookedArtist(WorkDay workDay, String artist){
            if(artist != null && !artist.equals("")) {
                workDay.setId(workDay.getId());
                workDay.setBookedArtist(artist);
                workDayRepository.save(workDay);
            }
        }