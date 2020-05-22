NOTE: you wont be able to understand your column names and values unless
you set the Cassandra Type hints via cassandra-cli.  To have a schema like below
where all un-referenced column types are UTF8Type:
   CREATE COLUMN FAMILY  MyColFam  WITH key_validation_class=UTF8Type
     AND default_validation_class=UTF8Type AND comparator=UTF8Type
     AND column_metadata = [ 
          {column_name: an_integer_column, validation_class: IntegerType}
         {column_name: a_long_column,     validation_class: LongType}
     ];