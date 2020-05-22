findById(id).thenAccept(
            result -> result.ifPresent(
                    entity -> { 
                        entity.setActive(false);
                        save(entity);
                    }
            )
    );