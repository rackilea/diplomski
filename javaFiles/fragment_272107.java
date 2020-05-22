try {
        ao_history_repository.save(new AoHistory(..));
    }
    catch (DataIntegrityViolationException e) {
        System.out.println("history already exist");
    }