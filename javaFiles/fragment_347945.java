if (source.getStringA() != null) {
        if (((((java.util.List) destination.getSomeObjects()).size() <= 0 || ((List) destination.getSomeObjects()).get(0) == null))) {
            ((java.util.List) destination.getSomeObjects()).add(0, ((BoundMapperFacade) usedMapperFacades[0]).newObject(((String) source.getStringA()), mappingContext));
        }
    }

    if (!(((java.lang.String) source.getStringA()) == null)) {
        (((java.util.List) destination.getSomeObjects()).get(0)).setStringSomeObject(source.getStringA());
    } else if (!(((java.util.List) destination.getSomeObjects()) == null) && !((((java.util.List) destination.getSomeObjects()).size() <= 0 || ((List) destination.getSomeObjects()).get(0) == null))) {
        ( ((java.util.List) destination.getSomeObjects()).get(0)).setStringSomeObject(null);
    }