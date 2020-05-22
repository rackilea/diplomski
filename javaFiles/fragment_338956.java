Predicate predicateOnManufacturerId = cb.equal(mf.get("id"), 
                                               manufacturer.getId());
Predicate predicateOnShortName = cb.like(cb.upper(m.<String>get("shortName")),
                                         pattern.toUpperCase()));
Predicate predicateOnLongName = cb.equal(cb.upper(m.<String>get("longName")),
                                         pattern.toUpperCase()));
Predicate p = cb.or(cb.and(predicateOnManufacturerId, 
                           predicateOnShortName),
                    predicateOnLongName);
cq.where(p);