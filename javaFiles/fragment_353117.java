SELECT SUM(DECODE(VVS.VVS_ZWS_ID, 
              47, DECK.DEC_BRUTTOPRAEMIE_100, 
              DECK.DEC_BRUTTOPRAEMIE_FOLGE))
FROM deck
JOIN vvs
  ON deck.dec_ver_nummer = vvs.vvs_ver_nummer
  AND deck.dec_vvs_nummer = vvs.vvs_nummer
JOIN agv
  ON agv.agv_code = vvs.vvs_agv_code
LEFT JOIN agd
  ON deck.dec_agd_code = agd.agd_code
WHERE vvs.vvs_ver_nummer = verNummer
  AND vvs.vvs_nummer = vvsNummer 
  AND deck.dec_tbl_code = 'KH'
  AND (    NVL(agv.agv_aenderungstyp, 'NULL') IN ('4', '5')
    OR NVL(agd.agd_aenderungstyp, 'NULL') NOT IN ('4', '5'));