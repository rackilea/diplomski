try {
   Field f = obb.getClass().getField("canBeSubmerged");
   if (f!=null && f.getBoolean(obb)) {
      // do your work
   }
} catch (Exception e) {
}