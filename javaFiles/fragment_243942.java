String equip = "equipID";
String equipInfo = "";
//String[] rEquipInfo = {equipInfo};
Memory rEquipInfo = new Memory(256);
IE2E sdll = IE2E.INSTANCE;
int ret = sdll.GetLocalPortTS(equip, rEquipInfo);