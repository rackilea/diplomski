CREATE VIEW SAMPLE_TEST(server, xml) AS
  SELECT SS.server,
    XMLCONCAT(
      DS.DomainSettings,
      SS.ServerSettings
    )
  FROM (
         SELECT S.ID AS SERVER
              , S.SERVERSETTINGS -- ?
           FROM SERVER S
          INNER JOIN SAMPLE_MAC DMA 
             ON S.DOMAIN = DMA.DOMAIN 
        ) SS
        INNER JOIN (SELECT S.ID AS SERVER,
                         ,  S.DOMAINSETTINGS -- ?
                      FROM SERVER S
                           INNER JOIN DOMAIN D 
                              ON D.ID = S.DOMAIN) DS 
           ON SS.server = DS.server;