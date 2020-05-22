SELECT a.apartmentID, a.apartmentNAME   
FROM tblAPARTMENT a
WHERE a.apartmentID NOT IN (SELECT a.apartmentID
                            FROM tblRESERVATION r  
                            WHERE r.startDate <= _a-date_ AND r.endDate >= _a-date_
                           );