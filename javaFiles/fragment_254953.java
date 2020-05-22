s2=edittext.getText().toString();
spe.putString("quty", s2);

spe.commit();
//OR if Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD
spe.apply();