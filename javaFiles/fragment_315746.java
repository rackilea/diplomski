DELIMITER //
CREATE TRIGGER updateStock AFTER INSERT ON invoice
  FOR EACH ROW BEGIN
      UPDATE stock set QntyAvailable=QntyAvailable- new.Qty WHERE Pno =new.Pno;
  END;
//
DELIMITER ;