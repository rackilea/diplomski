@PostMapping()
public ResponseEntity post(@Valid @RequestBody Item item, BindingResult bindingResult){

    if (bindingResult.hasErrors()){
        return ResponseEntity.badRequest().body(new ModelErrors(bindingResult));
    }

    return ResponseEntity.created().body(itemService.addItem(item));
}