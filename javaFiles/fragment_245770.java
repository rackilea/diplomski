} catch (Exception e) {
    e.printStackTrace();
} finally {
   if (file.exists()) {
    file.delete();
   }
}