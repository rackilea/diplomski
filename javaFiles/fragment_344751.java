ClassX def;
for (ClassX value : listabc) {
   if (value.Id.equals(currentId)) return value;
   if (value.Id.equals(defaultId)) def = value;
}
return def == null ? listabc.get(0) : def;