public List<Demande> getAllDemandes() {
    allDemandes = demandeServicesLocal.findAllDemandes();
    Collections.sort(allDemandes, new Comparator<Demande>()
    {
        @Override
        public int compare(Demande d1, Demande d2)
        {
            return d1.getdate().compareTo(d2.getdate());//use the name specified in the pojo class for getting the date in the place of 'getdate'
        }
    });
    return allDemandes;
}