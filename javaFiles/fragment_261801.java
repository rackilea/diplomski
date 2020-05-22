private static final Set<String> P_FORMATS = new HashSet<String>(Arrays.asList(
    "odt,ott,oth,odm,sxw,stw,sxg,doc,dot,xml,docx,docm,dotx,dotm,doc,wpd,wps,rtf,txt,csv,sdw,sgl,vor,uot,uof,jtd,jtt,hwp,602,pdb,psw,ods,ots,sxc,stc,xls,xlw,xlt,xlsx,xlsm,xltx,xltm,xlsb,wk1,wks,123,dif,sdc,vor,dbf,slk,uos,pxl,wb2,odp,odg,otp,sxi,sti,ppt,pps,pot,pptx,pptm,potx,potm,sda,sdd,sdp,vor,uop,cgm,bmp,dxf,emf,eps,met,pbm,pct,pcd,pcx,pgm,plt,ppm,psd,ras,sda,sdd,sgf,sgv,svm,tgs,tif,tiff,vor,wmf,xbm,xpm,jpg,jpeg,gif,png,pdf,log".split(","));

if(P_FORMATS.contains(extension.toLowerCase())){
    // do stuff
}