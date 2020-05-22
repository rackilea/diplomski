@RequestMapping(value = "bar", method = RequestMethod.POST)
public ResponseEntity<Void> bar(@RequestBody @Valid Foo foo, BindingResult bindingResult) 
{
    if (bindingResult.hasErrors()) {
        //do something if errors occured
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } 

    //body part
    return ResponseEntity.status(HttpStatus.OK).build();
}