public CompletableFuture<ChildDTO> findChild(@NotEmpty String id) {
            return ChildRepository.findAsyncById(id)
                    .thenApply(optionalChild -> optionalChild
                            .map(Child -> ObjectMapperUtils.map(Child, ChildDTO.class))
                             // If child last name is empty then return empty optional
                            .filter(child->!child.getLastName())   
                             // If optional is empty then throw exception
                            .orElseThrow(CurrentDataNotFoundException::new))