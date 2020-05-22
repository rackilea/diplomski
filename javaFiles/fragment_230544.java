CREATE VIEW ServerSettings AS (
    SELECT S.ID AS SERVER
         , S.SETTINGS   -- SETTING COLUMN(S)? 
      FROM SERVER S
           INNER JOIN SAMPLE_MAC DMA 
              ON S.DOMAIN = DMA.DOMAIN;

CREATE VIEW DomainSettingsAS AS (
    SELECT S.ID AS SERVER,
         , D.DOMAINSETTINGS -- DOMAIN SETTINGS COLUMN(S) 
      FROM SERVER S
             INNER JOIN DOMAIN D 
                ON D.ID = S.DOMAIN;

SELECT SS.server,
       XMLCONCAT(
             DS.DomainSettings,
             SS.ServerSettings )
  FROM ServerSettings SS
       INNER JOIN DomainSettings DS 
          ON SS.server = DS.server;