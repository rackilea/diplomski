String[] workedPer = null;
try
{
    workedPer = newPer.split("=");
    workedPer[1] = workedPer[1].substring(0, workedPer[1].length() -1);
}