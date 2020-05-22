for (Pending pn : pending) {
   if (a.length() + pn.getPm_str().length() <= 160) {
    a += pn.getPm_str();
}
else
break;
}