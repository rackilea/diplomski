@Entity
@Configurable
@Table(name = "TABLE_A")
public class TableA {
   @Id
   @Column(name = "KEY", nullable = false)
   private int key;

   @Transient
   private List<TableB> listOfBs;

   @Transient
   @Autowired
   AtoBRepository aToBRepository;

   @Transient
   @Autowired
   TableBRepository tableBRepository;

   public List<TableB> getListOfBs(){
      if (listOfBs == null){
         listOfBs = new ArrayList<>();
         List<AtoB> AtoBs = aToBRepository.findByIdKeyA(key);
         for (AtoB aToB : AtoBs){
            listOfBs.addAll(tableBRepository.findByIdKey(aToB.getKeyB));
         }
      }
      return listOfBs;
   }

   /* More Fields, Getters and setters*/
}