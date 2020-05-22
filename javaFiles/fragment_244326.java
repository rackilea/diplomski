List<Account> accs = [SELECT Id, Name
    FROM Account
    WHERE Id IN (SELECT Distributor__c FROM Monthly__c)
        AND Id IN (SELECT Distributor__c FROM Yearly__c)
    ORDER BY Name
    LIMIT 1000];

Set<String> keys = new Set<String>();

for(Monthly__c m : [SELECT AC_Sponsor_Key__c
    FROM Monthly__c
    WHERE Distributor__c IN :accs AND AC_Sponsor_Key__c != null]){
    keys.add(m.AC_Sponsor_Key__c);
}

for(Yearly__c y : [SELECT Id, Distributor__c, AC_Sponsor_Key__c
    FROM Yearly__c
    WHERE Distributor__c IN :accs AND NOT IN :keys
    ORDER BY Distributor__c, AC_Sponsor_Key__c]){
    System.debug(y);
}