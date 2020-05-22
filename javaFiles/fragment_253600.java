@namespace("com.sample")
protocol sample {
   record Category {
      union {null, string} price_score = null;
      union {null, string} confidence_score = null;
   }
   record vObject {
      int site_id = 0;
      union {null, map<Category>} categories = null;
      union {null, float} price_score = null;
      union {null, float} confidence_score = null;
   }

   record SampleObject {
      union {null, array<vObject>} lv = null;
      long lmd = -1;
   }
}