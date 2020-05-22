public class ArrayIntsTypeHandlerCallback implements TypeHandlerCallback {

     /**
      * to write an integer array in db. Object should be Integer[]
      */    
      public void setParameter(ParameterSetter setter, Object parameter) throws SQLException  {
          Connection con = setter.getPreparedStatement().getConnection();
          // hack: if using poolable connection from dbcp must get inside true connection! 
          if(con instanceof org.apache.commons.dbcp.PoolableConnection ) {
              con =     ((org.apache.commons.dbcp.PoolableConnection)con).getInnermostDelegate();
          }
          Array array = con.createArrayOf("integer", (Object[])parameter);
          setter.setArray(array);
        }

      /**
       * read integer array from db. returns Integer[]
       */
      public Object getResult(ResultGetter getter) throws SQLException {
        Array array = getter.getArray();
        if (!getter.getResultSet().wasNull()) {
          return array.getArray();
        } else {
          return null;
        }
      }

      public Object valueOf(String s) {
        throw new UnsupportedOperationException("Not implemented");
      }


    }