Optional<Entry>  optional =  entryRepository.findByNom(nom);
Entry entry=optional.orElseThrow(() -> new NotFoundException(this.getClass().getName()));
    if(!StringUtils.isEmpty(entryReq.getEmail())){
        entry.setEmail(entryReq.getEmail());
    } 
return save(entry);