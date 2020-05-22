public static Specification<UpdatePackage> useCaseNames(final List<String> useCaseNames) {
        return new Specification<UpdatePackage>() {

            @Override
            public Predicate toPredicate(Root<UpdatePackage> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {               
                final Join<UpdatePackage, Version> version = root.join(UpdatePackage_.destVersion,
                        JoinType.LEFT);
                final Join<Version, UseCase> useCase = version.join(Version_.useCases);
                return useCase.get(UseCase_.name).in(useCaseNames);
            }
        };
    }