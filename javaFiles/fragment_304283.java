public static ArrayList<String> getSpacecraftDescriptionsByCommissionYear(ArrayList<ISpacecraft> fleet){
       ArrayList<ISpacecraft> objects = new ArrayList<>(fleet);
       Collections.sort(objects, Comparator.comparingInt(ISpacecraft::getCommissionYear));
       ArrayList<String> strCommissions = new ArrayList<String>();
       objects.forEach(o -> strCommissions.add(o.toString()));
       return strCommissions;
}