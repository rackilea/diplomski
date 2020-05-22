CREATE TABLE `workday` (
      `idworkday` int(11) NOT NULL AUTO_INCREMENT,
      `start` time DEFAULT '08:00:00',
      `end` time DEFAULT '17:00:00',
      `workweekID` int(11) DEFAULT NULL,
      `DAY_TYPE` enum('MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY') DEFAULT NULL,
      PRIMARY KEY (`idworkday`),
      KEY `fk_workweek_workweekID` (`workweekID`),
      CONSTRAINT `fk_workweek_workweekID` FOREIGN KEY (`workweekID`) REFERENCES `workweek` (`idworkweek`) ON DELETE CASCADE ON UPDATE NO ACTION
    ) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 ;