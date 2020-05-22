unsigned i;
auto num = axe::r_unsigned(i);
auto space = axe::r_any(" \t");
auto format1 = num % (*space & ',' & *space) & ~("and" & +space & num);
auto format2 = num & +space & "through" & +space & num;
auto format3 = num & +space & "to" & +space & num;
auto format4 = num & +space & "or" & +space & num;
auto format = "items" & +space & (format1 | format2 | format3 | format4);