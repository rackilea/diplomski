String query = "DELETE error_log FROM error_log INNER JOIN "
                + "(SELECT  min(id) minid, service_source, channel,transaction_type, provider_name,     pido_account, beneficiary_id, error_description, error_date FROM error_log "
                + "GROUP BY service_source, channel, transaction_type, provider_name, pido_account, beneficiary_id, error_description, error_date "
                + "HAVING COUNT(1) > 1 ) AS duplicates ON "
                        + "(duplicates.service_source = error_log.service_source AND duplicates.channel = error_log.channel "
                    + "AND duplicates.transaction_type = error_log.transaction_type AND duplicates.provider_name = error_log.provider_name "
                    + "AND duplicates.pido_account = error_log.pido_account AND duplicates.beneficiary_id = error_log.beneficiary_id "
                    + "AND duplicates.error_description = error_log.error_description AND duplicates.error_date = error_log.error_date "
                    + "AND duplicates.minid <> error_log.id"
                    + ")";

        int deploy = duplicate.executeUpdate(query);