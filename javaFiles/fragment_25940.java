class UserController {

  @Autowired
  private CarRepository carRepository;

  @GetMapping("/users/{id}/cars")
  public ResponseEntity<Collection<Car>> getAllCarsByUserId(@PathVariable("id") Long id) {
      return ResponseEntity.ok(carRepository.findByUserId(id));
  }

}