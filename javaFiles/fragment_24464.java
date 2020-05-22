public String PACK_LIB = "";
public void setDefaultStickerPack() {
    checkVersion(true);
    InputStream in = null;
    String packList[]=new String[0];
    final String PACK_APP="pack_app";
    final String PACK_ICON="pack_on.png";
    String curAssets="";