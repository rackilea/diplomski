public class HouseServiceImpl implements HouseService{
  private  HouseRepo hRepo;

    public HouseServiceImpl(HouseRepo hRepo) {
        this.hRepo = hRepo;
    }

    @Override
    public List<House> index() {
        return null;
    }

    public House show(Integer id) {
        Optional<House> opt = hRepo.findById(id); 
        House house = new House();
        if (opt.isPresent()) {
            house = opt.get();
        }
        return house;
    }

}