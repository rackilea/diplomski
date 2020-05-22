findById(id).thenApply(
            result -> { 
                       result.ifPresent(
                            entity -> { 
                                entity.setActive(false);
                                save(entity);
                            }
                        );
                        return 1;
                    }
    );