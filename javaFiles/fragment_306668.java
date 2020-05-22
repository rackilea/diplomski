public class TestEntityPK implements Serializable {

       private static final long serialVersionUID = -3424067518791080014L;

       private String ssn;
       private String subTestCd;

       public TestEntityPK() { // }

       public TestEntityPK(String ssn, String subTestCd) {
           this.ssn = ssn;
           this.subTestCd;
       }

       public String getSsn() {
          return ssn;
       }

       public String getSubTestCd() {
          return subTestCd;
       }

      @Override
      public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
          result = prime * result
            + ((subTestCd == null) ? 0 : subTestCd.hashCode());
          return result;
      }

      @Override
      public boolean equals(Object obj) {
          if (this == obj)
              return true;
          if (obj == null)
              return false;
          if (getClass() != obj.getClass())
              return false;
          TestEntityPK other = (TestEntityPK) obj;
          if (ssn == null) {
             if (other.ssn != null)
                 return false;
          } else if (!ssn.equals(other.ssn))
              return false;
          if (subTestCd == null) {
              if (other.subTestCd != null)
                  return false;
           } else if (!subTestCd.equals(other.subTestCd))
              return false;
           return true;
      }