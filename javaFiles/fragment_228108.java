public void delete() throws Exception {
-        String query = "DELETE FROM " + this.activity.merchant + "_activity_metrics WHERE uuid = ?";
+        String merchant = this.getActivity().getMerchant();
+        String query = "DELETE FROM " + merchant + "_activity_metrics WHERE uuid = ?";
         System.out.println(query);
-        System.out.println(this.activity.uuid);
+        System.out.println(this.getActivity().getUuid());