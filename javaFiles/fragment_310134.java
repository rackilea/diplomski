Map<String, Long> duplicateNames =
        members .stream()
                .collect(Collectors.groupingBy(Member::getName,
                         Collectors.counting()));
members .stream()
        .collect(Collectors.groupingBy(Member::getOrg))
        .forEach((org, orgList) -> {
            System.out.printf("%n*** Members that joined other organizations within %s:%n", org);
            orgList .stream()
                    .map(Member::getName)
                    .filter(name -> duplicateNames.get(name)>1)
                    .forEach(name -> {
                        System.out.printf("   ** Member: %s %n", name );
                    });
        });