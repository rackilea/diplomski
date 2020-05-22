enum Catalog {
      year2005(9),year2006(12),year2007(15),year2008(18),
      year2009(21),year2010(23),year2011(25),year2012(28),
      year2013(31),year2014(33),year2015(36),year2016(39),
      year2017(42),year2018(45),year2019(48),year2020(51);
      private int id;

      Catalog(int c){
         this.id=c;
      }


      static Map<Integer, Catalog> map = new HashMap<>();

      static {
         for (Catalog catalog : Catalog.values()) {
            map.put(catalog.id, catalog);
         }
      }

      public static Catalog getByCode(int code) {
         return map.get(code);
      }
   }