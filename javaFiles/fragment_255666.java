SELECT a.apartmentID, a.apartmentNAME   
FROM tblAPARTMENT a
WHERE NOT EXISTS (SELECT a.apartmentID
                  FROM tblRESERVATION r  
                  WHERE r.startDate <= _a-date_ AND r.endDate >= _a-date_ and
                        r.apartmentid = a.apartmentid
                 );