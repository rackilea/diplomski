for(int i =0; i< JpassatemposList.size(); i++){
        Hibernate.initialize(JpassatemposList.get(i).getJpatrocinadoresPassatemposes());

        for(JpatrocinadoresPassatempos pp : JpassatemposList.get(i).getJpatrocinadoresPassatemposes()){
           Hibernate.initialize(pp.getJpatrocinadores());
        }

    }
    return JpassatemposList;