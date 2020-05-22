USING PERIODIC COMMIT 2000
LOAD CSV WITH HEADERS FROM "file:c:/sunshine.anonymes.csv" AS line
FIELDTERMINATOR ','
MATCH (b:DOCTOR {ID: line.BENEF_PS_ID})
MATCH (a:PHARMA {NAME: line.LABO})
MERGE (a)-[r:IS_LINKED_TO]->(b)
ON CREATE SET r.numberDECL = 1, r.totalDECL = toINT(line.DECL_AVANT_MONTANT)
ON MATCH SET r.numberDECL = r.numberDECL +1, r.totalDECL = line.totalDECL + r.totalDECL;