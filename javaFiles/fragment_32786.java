boolean test0(Table table, String[] msgDetails){
   return "QUEUE_R".equals(table.getDeliveryChannel()) && "A".equals(msgDetails[0])) ||
            ("M".equals(table.getDeliveryChannel()) && "F".equals(msgDetails[0])) ||
            ("QUEUE_Q".equals(table.getDeliveryChannel()) && "S".equals(msgDetails[0])) ||
            ("QUEUE_W".equals(table.getDeliveryChannel()) && "S".equals(msgDetails[0])) ||
            ("QUEUE_Q".equals(table.getDeliveryChannel()) && "C".equals(msgDetails[0]) && "DD_SRC_MESS".equals(table.getCode())) ||
            ("QUEUE_Q".equals(table.getDeliveryChannel()) && "C".equals(msgDetails[0]) && "DD_TGT_MESS".equals(table.getCode()))
}