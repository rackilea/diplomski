.map(api-> {
    try {
        return api.get().getRandomText());
    }
    catch (ExecutionException e) {
        // TODO: return something else or throw a runtime exception
    }
})