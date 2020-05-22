SWIGTYPE_p_int p1 = calc.new_intp();
SWIGTYPE_p_int p2 = calc.new_intp();
calc.intp_assign(p1, 1);
calc.intp_assign(p2, 2);

System.out.println(calc.sum_1(p1, p2));

calc.delete_intp(p1);
calc.delete_intp(p2);