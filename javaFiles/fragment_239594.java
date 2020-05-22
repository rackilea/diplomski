public class EquipmentComparable implements Comparator<SearchEquipement>{
  @Override
  public int compare(Equipement eq1, Equipement eq2) {
        //todo 
  }
 }


   List<Equipement> equipmentList = EquipementService.findEquipements  (equipementSerach);
   Collections.sort(equipmentList,new EquipmentComparable());