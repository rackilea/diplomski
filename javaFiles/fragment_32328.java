String parFrm_topk = request.getParameter("frm_topk");
Integer frm_topk = null;
if (parFrm_topk != null && parFrm_topk.length() > 0 && !parFrm_topk.equals("null"))
try {
  frm_topk = Integer.valueOf(parFrm_topk);
} catch (NumberFormatException nfe){
  throw nfe;
}
if (frm_topk ! = null) {
   query.setTopK(frm_topk);