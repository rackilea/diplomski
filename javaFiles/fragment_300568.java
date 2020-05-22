if (order == null) {
  query = "SELECT * FROM codes WHERE prod_deploy_state IN ('LIVE','Dormant','...')";
}else if (order.equals("code_ready_date")) {
  query = "SELECT * FROM codes WHERE prod_deploy_state IN ('LIVE')";
} else {
  query = "SELECT * FROM codes WHERE prod_deploy_state IN ('LIVE','Dormant','...')";
}