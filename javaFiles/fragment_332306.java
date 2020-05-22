Optional<Entry>  optional =  entryRepository.findByNom(nom);
Entry updatedEntry = null;
if(optional.isPresent()){
    Entry entry=optional.get();
    if(!StringUtils.isEmpty(entryReq.getEmail())){
        entry.setEmail(entryReq.getEmail());
    }
    updatedEntry = save(entry);
});
optional.orElseThrow(() -> new NotFoundException(this.getClass().getName()));
return updatedEntry;