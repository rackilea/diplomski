getJdbcTemplate().update(sql,  
              tri.getPolizzaID(),
              tri.getPercRendimentoInizioSottoscrizione(),
              tri.getPercRendimentoInizioAnno(),
              tri.getPercRendimentoInizioTrimestre(),
              tri.getControvaloreQuote(),
              tri.getDataRiferimentoNavPUC());