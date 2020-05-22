public class DBItemReader implements ItemReader {  

    // ... 

    // CHECKPOINT field defined
    private String checkpoint = null; 

    @Override
    public void open(Serializable checkpoint) throws NamingException, SQLException {

        // CHECKPOINT-based positioning through query value.
        // Initial position = whereclauseFrom, on restart set to checkpoint
        String queryVal = (String)(checkpoint == null ? whereclauseFrom : checkpoint);       

        if(Integer.parseInt(whereclauseFrom) == 5){
            sql = "SELECT * FROM " + tableName + " WHERE  CAST(REC AS INTEGER) <= "+ queryVal;
        }else if(Integer.parseInt(whereclauseFrom) == 6){
            sql = "SELECT * FROM " + tableName + " WHERE  CAST(REC AS INTEGER) >= "+ queryVal;
        }
        // ..
    }

    @Override
    public Object readItem() throws SQLException {
        if (listRecObj.size() == 0) {             
            return null;
        } else { 
            RecObj rec =null;           
            Iterator<RecObj> iter =listRecObj.iterator();
            while (iter.hasNext()) {               
                rec = iter.next();               
                // CHECKPOINT updated
                checkpoint = rec.getRec();
                if (Integer.parseInt(rec.getRec())  == 7) {                      
                    throw new IllegalStateException("Thrown Error");
                }
            }
        }
        // ...
    }

    @Override
    public Serializable checkpointInfo() {      
        // CHECKPOINT returned at end of chunk
        return checkpoint;
    }
}