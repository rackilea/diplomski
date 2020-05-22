interface TypeDependentBehavior<T> {
   void setFieldValue(PreparedStatement st, T value);
}

interface StringBehavior extends TypeDependentBehavior<String> {
   void setFieldValue(PreparedStatement st, String value) {
     st.setString(3, value);
   }
}    

interface IntBehavior extends TypeDependentBehavior<Integer> {
   void setFieldValue(PreparedStatement st, Integer value) {
     st.setInt(3, value);
   }
}