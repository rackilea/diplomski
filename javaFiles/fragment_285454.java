expectedPackageRepository.findById(1).ifPresent(
    ep -> {
        ep.setDateModified(new Date());
        expectedPackageRepository.saveAndFlush(ep);
    }
);