CREATE TABLE 
`delidete`.`DatiGeneraliVistoContabile` (
`DatiGeneraliId` int NOT NULL,       <---- P.K., Foreign key to table Datigenerali
`SoggettiCodice` int NOT NULL,       <---- P.K., Foreign key to table Soggetti
`DGVCDataInizio` date NOT NULL, 
`DGVCDataFine` date) ;

CREATE TABLE 
`delidete`.`DatiGeneraliParereTecnico` (
`DatiGeneraliId` int NOT NULL,       <---- P.K., Foreign key to above table (DatigeneraliId)
`SoggettiCodice` int NOT NULL,       <---- P.K., Foreign key to above table (SoggettiCodice)
`DGTPDescrizione` varchar (255) NOT NULL,
`DGTPDataInizio` date NOT NULL, 
`DGTPDataFine` date) ;