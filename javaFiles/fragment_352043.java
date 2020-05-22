StringBuilder updateStmt = new StringBuilder();
updateStmt.append("update CampaignStructure ");
updateStmt.append("set accountId = :accountId ");
updateStmt.append(", budget = :budget");
...
updateStmt.append(" where campaignId = :campaignId");