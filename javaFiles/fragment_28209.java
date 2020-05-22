sql = "SELECT SUM(TOTAL_BYTES_DELIVERED) / SUM(TOTAL_TIME_TAKEN_IN_DELIVERY) 
         FROM MV_MFT_TRANSFER 
        WHERE TRANSFER_INITIATION_TIME > ?
          AND TRANSFER_INITIATION_TIME < ?"

Query query = em.createNativeQuery(sql);
query.setParameter(1, startDate, TemporalType.DATE);
query.setParameter(2, endDate, TemporalType.DATE);
query.getResultList();