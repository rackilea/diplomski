stat.setString(1, (String)cmbNat.getSelectedItem());
rslt = stat.executeQuery();
Integer foo = null;
if (rslt.next())
    foo = rslt.getObject("foo") != null ? rslt.getInt("foo") : null;
return foo;