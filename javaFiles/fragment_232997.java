@PostMapping
@ResponseBody
public ResponseEntity createMany(@RequestBody ManyDTO many) {
    One one = oneRepository(many.getOne_id()); //Get the parent Object
    Many newMany  = new Many(); //Create a new Many object
    newMany.setName(many.getName());
    newMany.setOne(one); // Set the parent relationship

    ...

}