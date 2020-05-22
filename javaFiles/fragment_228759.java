@RequestMapping(value = "/add-car", method = RequestMethod.POST)
public ResponseEntity<List<MuscleCar>> 
        addCarToList(@RequestBody MuscleCar muscleCar) {
    try {
       List<MuscleCar> mc = m.addCarToList(muscleCar);
       return ResponseEntity.status(HttpStatus.OK).body(mc);
    } catch (Exception e) {
       e.printStackTrace();
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}