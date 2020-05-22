String sch_name = "sch_test";
String sequence_name = "sequence_name";

//Check if your sequence exist or not
Query q = createNativeQuery("SELECT COUNT(*) FROM        
                             information_schema.sequences 
                             WHERE sequence_schema='" + sch_name + "' 
                             AND sequence_name='" + sequence_name + "'");

int i = (Integer) q.getSingleResult();
int sequence = 0;

//if the sequence exit it will return 1
if(i == 1){
  //increment your sequence and return the result
  q = createNativeQuery("SELECT nextval('" + sequence_name + "')");
  sequence = (Integer) q.getSingleResult();
}else{
   //sequence not exist
}