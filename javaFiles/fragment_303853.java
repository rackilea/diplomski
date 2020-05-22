public void save() {

    if (this.enterprise.getId() == null) {

        this.country = this.countryBean.findByName("Brazil").get(0);

        if (this.stateBean.searchStateByAbbreviation(this.state.getAbbreviation())) {
            Map<String, Object> map = new HashMap<>();
            map.put("abbreviation", this.state.getAbbreviation());
            State sta = (State) this.stateBean.findWithNamedQuery("State.findByAbbreviation", map).get(0);
            this.state = sta;
        } else {
            this.state.setCountry(this.country);
            this.stateBean.add(this.state);
        }

        this.city.setState(this.state);

        if (this.cityBean.searchCityByName(this.city.getName())) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", this.city.getName());
            City cit = (City) this.cityBean.findWithNamedQuery("City.findByNome", map).get(0);
            this.city = cit;
        } else {
            this.cityBean.add(this.city);
        }

        if (this.zipCodeBean.searchZipCodeByNumber(this.zipCode.getNumber())) {
            Map<String, Object> map = new HashMap<>();
            map.put("number", this.zipCode.getNumber());
            ZipCode zip = (ZipCode) this.zipCodeBean.findWithNamedQuery("ZipCode.findByNumber", map).get(0);
            this.zipCode = zip;
        } else {
            this.zipCodeBean.add(this.zipCode);
        }

        this.neighbourhood.setCity(this.city);
        this.neighbourhood.setZipCode(this.zipCode);

        if (this.neighbourhoodBean.searchNeighbourhoodByName(this.neighbourhood.getName())) {
            Map<String, Object> map = new HashMap<>();
            map.put("nome", this.neighbourhood.getName());
            Neighbourhood ngb = (Neighbourhood) this.bairroBean.findWithNamedQuery("Neighbourhood.findByName", map).get(0);
            this.neighbourhood = ngb;
        } else {
            this.neighbourhoodBean.add(this.neighbourhood);
        }

        this.street.setNeighbourhood(this.neighbourhood);

        if (this.streetBean.searchStreetByName(this.street.getName())) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", this.street.getNome());
            Street str = (Street) this.streetBean.findWithNamedQuery("Street.findByNome", map).get(0);
            this.street = str;
        } else {
            this.streetBean.add(this.street);
        }

        this.enterprise.setCountry(this.country);
        this.enterprise.setState(this.state);
        this.enterprise.setCity(this.city);
        this.enterprise.setZipCode(this.zipCode);
        this.enterprise.setNeighbourhood(this.neighbourhood);
        this.enterprise.setStreet(this.street);

        this.enterpriseBean.add(this.enterprise);

    } else {

        this.country = this.countryBean.findByEnterpriseId(this.enterprise.getId());
        this.state = this.stateBean.findByEnterpriseId(this.enterprise.getId());
        this.city = this.cityBean.findByEnterpriseId(this.enterprise.getId());
        this.zipCode = this.zipCodeBean.findByEnterpriseId(this.enterprise.getId());
        this.neighbourhood = this.neighbourhoodBean.findByEnterpriseId(this.enterprise.getId());
        this.street = this.streetBean.findByEnterpriseId(this.enterprise.getId());

        this.enterpriseBean.edit(this.enterprise);

    }

    this.enterprise = new Enterprise();

}