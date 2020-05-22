public CtThhlastikaPressThreats findCtThhlastikaPressThreatsById(Long id){
    try {
        // TODO: 11/17/2018 !!! -- Try as an Optional findById(id) instead!!!
        return ctThhlastikaPressThreatsRepository.findCtThhlastikaPressThreatsById(id);
    }catch (Exception e){
        throw  e;
    }
}