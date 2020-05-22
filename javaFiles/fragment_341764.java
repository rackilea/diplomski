log.info("CounterpartyStatement [selectByReviewDateAndTeamStmt]");
    selectByReviewDateAndTeamStmt       =  cassandraDatasource.getSession().prepare(" select  id, parent_id, ultimate_parent_id, internal_ref, short_name, long_name, controlling_team, " +
                                            " country_incorp, country_operate, company_reg, relationship_manager, credit_rating, rating_source, pd, lgd, review_date, sector, defaulted, own_bank_entity " +
                                            " from counterparty where filter_column = '{ " 
                                                         + " filter : {type:\"range\", field:\"review_date\", lower:\"01-01-2000\", upper:\"%s\"},"
                                                         + " query : {type:\"contains\", field:\"controlling_team\", values:[\"%s\"]},"
                                                         + " refresh:true"
                                                         + " }'");