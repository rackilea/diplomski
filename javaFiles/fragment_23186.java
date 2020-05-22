StringBuffer sb = new StringBuffer();
  sb.append("from Hardwarekomponente h ");
  sb.append(" left join h.konto k with (k.sisnetConfigSwitch = 1)");  
  sb.append(" left join h.hwCategory4 c4");
  sb.append(" left join c4.hwCategory3 c3 with (upper(c3.hwCategory3) like :cat3) ");
  sb.append(" where ");
  sb.append("  h.technischeNr is not null ");