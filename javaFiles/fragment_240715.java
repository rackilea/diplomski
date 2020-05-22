class Specification1 implements Specification<Event> {            
            private final List<Pair<String, String>> pairs;

            public Specification1(List<Pair<String, String>> pairs) {
                this.paris = pairs;
            }

            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {


                Predicate[] as = pairs.stream().map(pair -> {
                    return cb.and(cb.equal(root.get("originalId2"), pair.getKey())),cb.equal(root.get("originalCalendarId2"), pair.getKey());
                }).toArray(Predicate[]::new);

                return cb.or(as);
            }
        }


        userRepository.findAll(new Specification1(...));