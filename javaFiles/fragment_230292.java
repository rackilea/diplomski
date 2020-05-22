q = getEntityManager().createNamedQuery(
"select ... where c.clientId = :par1 and  c.vehicleReg1 like :par2 or c.vehicleReg2 like :par2");
//-------------------------------^^----------------------------^^--------------------------^^

q.setParamettre("par1", "value1");
q.setParamettre("par2", "value2");