DROP TRIGGER insert_before_update_slugrapat;

DELIMITER $$

CREATE TRIGGER insert_before_update_slugrapat
   BEFORE UPDATE
   ON slugrapat
   FOR EACH ROW
BEGIN
   INSERT INTO record_pemakaian_slug_rapat(rc_sr_size,
                                           rc_sr_stockawal,
                                           rc_sr_holling,
                                           rc_sr_store,
                                           rc_sr_sales,
                                           rc_sr_sisa,
                                           rc_sr_lastdate)
   VALUES (new.sr_size,
           new.sr_stockawal,
           new.sr_holling,
           new.sr_store,
           new.sr_sales,
           new.sr_sisa,
           new.sr_lastdate);

   INSERT INTO so_slugrapat(sr_size,
                            sr_sisa,
                            sr_stockakhir,
                            sr_stockopname,
                            sr_lastdate)
   VALUES (new.sr_size,
           new.sr_sisa,
           new.sr_stockakhir,
           new.sr_stockopname,
           new.sr_lastdate);
END$$
DELIMITER;