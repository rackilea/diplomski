String SectorCode = null;
String IndustrialCode = null;
try{
  SectorCode = employerProfile.getSectorCode().getSectorTypeId();
  IndustrialCode = employerProfile.getIndustrialCode().getIndustryTypeId();
  ...
}catch(Exception ex){
    if(SectorCode==null || IndustrialCode==null){
       JOptionPane.showMessageDialog(null, "Record not found" );
    }
}