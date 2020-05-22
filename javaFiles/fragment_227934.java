public void updateRecord(MemberRecord record) {
    MemberRecord oldRecord = record;
    record = record.clone();   //Added a clone() to MemberRecord
    getSession().evict(record);
    getSession().evict(oldRecord);
    getSession().refresh(oldRecord);
    // At this point, record has all of the new values, but none of the Hibernate
    //  data attached to it, due to the clone(). 
    // oldRecord is populated with the data currently in the database.

    Date oldEffectiveDate = oldRecord.getEffectiveDate();
    if ( isEffective(oldEffectiveDate) && 
         !oldEffectiveDate.equals(record.getEffectiveDate)) {
      throw new IllegalArgumentException("Cannot change date");
    }


    // << Other data checks >>
    memberRecordDAO.update(record);
  }