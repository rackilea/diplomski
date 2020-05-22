UserSpecification specName =
                    new UserSpecification(new SearchCriteria("name", ":", data.getName()));
UserSpecification specEnv =
                    new UserSpecification(new SearchCriteria("env", ":", data.getEnv()));

...

List list = gisMapRepository.findAll(Specification.where(specName).and(specEnv));