@Override
public void testUpdate() {
    Venue originalVenue = new Venue(0L, "The Venue");
    String originalName = originalVenue.getName();

    mockVenueRepository.update(originalVenue);
    replay(mockVenueRepository);

    originalVenue.setName("Another Venue");
    venueService.updateEntity(originalVenue);

    verify(mockVenueRepository);
}

@Override
public void testDelete() {
    mockVenueRepository.remove(venue1);
    replay(mockVenueRepository);

    venueService.deleteEntity(venue1);

    verify(mockVenueRepository);
}