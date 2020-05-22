SELECT * FROM (
 SELECT A.id, (SELECT count(*) as anzahl1 FROM ABTable p WHERE p.Aid =  A.id   AND p.refNR > 0) as anz1,   (SELECT count(*) as anzahl1 FROM ABTable p WHERE p.Aid = A.id  ) as anz2,   (SELECT count(*) as anzahl1 FROM ABTable p WHERE p.Aid = A.id AND p.SID = 18 ) as anz3   FROM ABable A
 WHERE A.someInt IN(1,2)
 AND A.someString > '20150308190127'
 AND(SELECT Count(*) FROM DTable D WHERE D.Aid = A.id ) = 0
) WHERE anz1 = anz2 AND anz3 < anz2 ORDER BY someString ASC LIMIT 1;