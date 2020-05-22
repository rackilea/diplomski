.setCreateBranch(!exampleRepo.branchList()
                        .call()
                        .stream()
                        .map(Ref::getName)
                        .collect(Collectors.toList())
                        .contains("refs/heads/" + branchName));