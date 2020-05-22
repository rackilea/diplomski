@Transactional
public void save(House house, List<Long> room) {        
    for (Long id : room) {
        house.getRooms().add(new Room(id));
    }
    houseDao.save(house);

}

public void save(House house) {
    entityManager.persist(house);
}