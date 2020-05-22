@Override public Bundle call (String method, String arg, Bundle bundle) {
 if (method.equals("set_expansion_file_versions")) {
  mainFileVersion  = bundle.getInt("main_version" , 1);
  patchFileVersion = bundle.getInt("patch_version", 1);
  expansionAuthority = bundle.getString("expansion_authority", "com.sample.expansion");
  xmlDataReceived = true;
  return null;
 }
 return null;
}