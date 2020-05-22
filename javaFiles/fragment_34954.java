@Transactional(readOnly = false, rollbackFor = Exception.class)
public void doMultiTableInsert(List<String> entries) throws Exception {


    // 1. Obtain current Sequence values
    Integer currTable1SeqVal = table1DAO.getCurrentTable1SeqVal();
    Integer currTable2SeqVal = table2DAO.getCurrentTable2SeqVal();     
    // 2. Immediately update the Sequences to the calculated final value (this reserves the ID range immediately)
    table1DAO.setTable1SeqVal(currTable1SeqVal + entries.size());          
    table2DAO.setTable2SeqVal(currTable2SeqVal + entries.size());           

    for(int i = 0; i < entries.size(); i++) {
         // Prepare Domain object...
         UsersT user = new User();
         user.setID(currTable1SeqVal + 1 + i); // Set ID manually
         user.setCreatedDate(new Date());
         // etc.
         StudyParticipantsT sp = new StudyParticipantsT();
         sp.setID(currTable2SeqVal + 1 + i); // Set ID manually
         // etc.
         user.setStudyParticipant(sp);

         // Add to Batch-Insert List
         batchInsertUsers.add(user);

         // If list size ready for Batch-Insert (in this ex. 1000), or if at the end of all subjectIds, perform Batch Insert (both tables) and clear list
         if (batchInsertUsers.size() == 1000 || i == subjectIds.size() - 1) {
            // Part 1: Insert batch into USERS_T
            nativeBatchInsertUsers(jdbcTemplate, batchInsertUsers);             
            // Part 2: Insert batch into STUDY_PARTICIPANTS_T
            nativeBatchInsertStudyParticipants(jdbcTemplate, batchInsertUsers);                 
            // Reset list
            batchInsertUsers.clear();
         }
    }

}