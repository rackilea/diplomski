package com.njugroup.flotilla.domain.factories;

import com.njugroup.flotilla.domain.maps.TermsMap;
import com.njugroup.flotilla.repository.TermsMapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataMapsFactory{

    private final Logger log = LoggerFactory.getLogger(TermsMapsFactory.class);

    @Autowired
    private TermsMapRepository termsMapRepository;

    public TermsMap getDataMapForVehicle(String id) {
        log.debug("Getting data map for: "+id);
        try {
            Optional<TermsMap> map = Optional.ofNullable(termsMapRepository.findOneByEntityId(id));
            log.debug("fetched map: "+map);
            return map.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}