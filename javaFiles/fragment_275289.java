public Parent update(@PathVariable("id") String id, @Valid @RequestBody       UpdateDto dto) {

Parent parentObj = parentRepository.findById(id);

childRepository.findByCode(dto.child().getCode())
                 .map(child -> { 
                       parentObj.setChild(child);
                       return child;
                  });
mapper.map(dto, parentObj); // Dozer dto to domain mapping was causing problem                   

return parentRepository.save(parentObj); 
}