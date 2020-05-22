class Dictionary{ 
   @Id     @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(unique = true, nullable = false)
   private String code;

   @Column
   private String ru;

   @Column
   private String lv;

   @Column
   private String en;
}