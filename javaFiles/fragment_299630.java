static public class CowLastInspectionComparator implements Comparator<Cow> {
  private Context context;
  CowLastInspectionComparator(Context context){
    this.context=context;
  }
  public int compare(Cow cow1, Cow cow2) {
    DbAdapter adapter = DbAdapter.getInstance(context); //this doesn't work
    List<Inspection> inspectionsCow1 = adapter.getInspectionByCow(cow1);
    List<Inspection> inspectionsCow2 = adapter.getInspectionByCow(cow2);

    return inspectionsCow1.get(0).getJob().getJobDate().compareTo(inspectionsCow2.get(0).getJob().getJobDate());
  }
}