SelectField[] fields = {
    field("field-1"), 
    field("field-2"), 
    field("field-3")
};
DSL.select(fields)
   .from(table("myTable"))