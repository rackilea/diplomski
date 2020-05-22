.collect(Collectors.collectingAndThen(ArrayList::new, rs -> {
                    if(rs.size() < 1 ) {
                        rs.add("something");
                    }
                   return rs;
                })