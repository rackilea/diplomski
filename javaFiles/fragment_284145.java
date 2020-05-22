return chars.codePoints().mapToObj(cp->
     Character.UnicodeBlock.SPECIALS.equals(Character.UnicodeBlock.of(cp))
  || Character.isISOControl(cp)?
     "0x"+Integer.toHexString(cp):
     "'"+String.valueOf(Character.toChars(cp))+"'")
  .collect(Collectors.joining(","));