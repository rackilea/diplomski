StringBuffer queryByCos4Allocation = new StringBuffer();
Flag ceIngress = null;
Flag ceEgress = null;
Flag peIngress = null;
Flag peEgress = null;
String      ce = null;
String      pe = null;
String both = null;
String toAppend = "";

if (Flag.Y.equals(ceIngress) || Flag.Y.equals(ceEgress)){
    ce =      " AND (CE_INGRESS_FLAG = 'Y' OR CE_EGRESS_FLAG = 'Y')  "
            + " AND (PE_INGRESS_FLAG = 'N' OR PE_EGRESS_FLAG = 'N') ";
    toAppend=ce;
}if (Flag.Y.equals(peIngress) || Flag.Y.equals(peEgress)){
    pe =      " AND (CE_INGRESS_FLAG = 'N' OR CE_EGRESS_FLAG = 'N')  "
            + " AND (PE_INGRESS_FLAG = 'Y' OR PE_EGRESS_FLAG = 'Y') " ;         toAppend=pe;
}if (ce!=null && ce.equals(pe)){
    both =    " AND (CE_INGRESS_FLAG = 'Y' OR CE_EGRESS_FLAG = 'Y')  "
            + " AND (PE_INGRESS_FLAG = 'Y' OR PE_EGRESS_FLAG = 'Y') " ;         toAppend=both;
}
queryByCos4Allocation.append("  SELECT * FROM TRAFFIC_PROFILE " ).append( 
            "   WHERE COS_MODEL = 'cos4'  " ).append(
            "   AND DIRECTION = ?  " ).append(
                    toAppend +
            "   and  TRAFFIC_PROFILE_ID IN " ).append(
            "   ( " ).append(
            "   select distinct (C1.Traffic_PROFILE_ID) from Cos_Class_Allocation C1, " ).append(
            "   Cos_Class_Allocation C2, Cos_Class_Allocation C3, Cos_Class_Allocation C4  " ).append(
            "   where c1.class_name = 'COS1' AND c1.CLASS_ALLOCATION = ? " ).append(
            "   and c2.class_name = 'COS2' AND c2.CLASS_ALLOCATION = ? " ).append(
            "   and c3.class_name = 'COS3' AND c3.CLASS_ALLOCATION = ? " ).append(
            "   and c4.class_name = 'COS4' AND c4.CLASS_ALLOCATION = ? " ).append(
            "   and C1.TRAFFIC_PROFILE_ID = c2.TRAFFIC_PROFILE_ID " ).append(
            "   and C1.TRAFFIC_PROFILE_ID = c3.TRAFFIC_PROFILE_ID " ).append(
            "   and C1.TRAFFIC_PROFILE_ID = c4.TRAFFIC_PROFILE_ID); " );